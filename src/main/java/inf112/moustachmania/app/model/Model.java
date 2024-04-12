package inf112.moustachmania.app.model;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.model.entities.IEntity;
import inf112.moustachmania.app.model.entities.Monster;
import inf112.moustachmania.app.model.entities.Player;
import inf112.moustachmania.app.screens.GameOverScreen;
import inf112.moustachmania.app.screens.GameWonScreen;
import inf112.moustachmania.app.screens.LevelScreen;

import java.util.ArrayList;
import java.util.Random;

public class Model implements IModel {

    private final Player player;
    private final MoustacheMania game;
    private final ArrayList<Monster> monsters;
    private TiledMapTileLayer collisionMap;
    private TiledMapTileLayer powerUpsLayer;
    private TiledMapTileLayer coinsLayer;
    private TiledMapTileLayer startPosLayer;
    private TiledMapTileLayer endPosLayer;
    private Vector2 endPos;
    private Array<Rectangle> tiles = new Array<Rectangle>();
    private static final float GRAVITY = -0.005f;
    private float timer = 10.0f;

    private Pool<Rectangle> rectPool = new Pool<Rectangle>() {
        @Override
        protected Rectangle newObject() {
            return new Rectangle();
        }
    };
    private Random rand = new Random();


    public Model(final MoustacheMania game, Player player) {
        this.game = game;
        this.player = player;
        this.monsters = new Monster().getNewMonsters();
    }


    /**
     * Updates the model
     * @param deltaTime The time since the last update
     */
    public void update(float deltaTime) {
        // Continuously try to make player fall
        player.velocity.add(0, GRAVITY);
        checkYCollision(player);
        player.position.add(player.velocity);

        moveMonstersAround();

        pickUpCoins(player);

        checkForPowerUp(player);
        if (player.powerUp) {
            timer -= deltaTime;
            if (timer <= 0) {
                player.powerUp = false;
                timer = 10;
            }
        }

        // Updating players stateTime. Important for the player animations.
        player.stateTime += deltaTime;

        // If player is slowing down, set speed to 0 and change frame
        if (Math.abs(player.velocity.x) < 1) {
            player.velocity.x = 0;
            if (player.grounded) player.state = Player.State.Standing;
        }

        // Check if player is in bounds of the screen
        checkPlayerOutOfBounds(player);

        // Check if player has reached the end position
        checkEndCollision(player);

        eliminateMonster(player);

        // multiply by delta time, so we know how far we go in this frame
        player.velocity.scl(deltaTime);
        player.velocity.scl(1 / deltaTime);
    }


    /**
     * When called upon from the controller, the model moves the player to the desired position.
     * @param x input speed from controller. Always 1, but is multiplied with MAX_VELOCITY from Player.java
     */
    public void movePlayer(int x) {
        player.velocity.x = x * Player.MAX_VELOCITY;
        checkXCollision(player);
        player.position.add(player.velocity);
    }


    /**
     * When called upon from the controller, the model makes the player jump
     * and moves the player upwards based on Player.JUMP_VELOCITY.
     * Sets Player.grounded = false.
     */
    public void jumpPlayer() {
        if (player.grounded) {
            if (player.powerUp) {
                player.velocity.y += (float) (Player.JUMP_VELOCITY*1.5);
            } else {
                player.velocity.y += Player.JUMP_VELOCITY;
            }
            player.grounded = false;
        }
    }


    private void moveMonstersAround() {
        for (Monster monster : monsters) {
            monster.velocity.add(0, GRAVITY);
            checkYCollision(monster);
            checkXCollision(monster);

            if (monster.movesRight) {
                monster.velocity.x = 1 * Monster.MAX_VELOCITY;
                monster.getPosition().add(monster.velocity);
                if (monster.getPosition().x >= monster.startPosition.x + 10 ) {
                    monster.movesRight = false;
                }
            } else {
                monster.velocity.x = -1 * Monster.MAX_VELOCITY;
                monster.getPosition().add(monster.velocity);
                if (monster.getPosition().x <= monster.startPosition.x) {
                    monster.movesRight = true;
                }
            }
        }
    }


    private void eliminateMonster(Player player) {
        Rectangle playerRect = rectPool.obtain();
        playerRect.set(player.position.x, player.position.y, Player.WIDTH, Player.HEIGHT);

        for (Monster monster : monsters) {
            Rectangle monsterRect = rectPool.obtain();
            monsterRect.set(monster.getPosition().x, monster.getPosition().y, Monster.WIDTH, Monster.HEIGHT);

            float diffX = Math.abs(player.position.x - monster.getPosition().x);
            float diffY = Math.abs(player.position.y - monster.getPosition().y);

            if (player.position.y > monster.getPosition().y && diffY < 1.0 && diffX < 1.0) { // Player comes from above
                // Check if player's bottom overlaps with monster's top
                if (player.position.y + Player.HEIGHT >= monster.getPosition().y + Monster.HEIGHT) {
                    monster.eliminate(monster); // Player comes from above, eliminate monster
                    break;
                }
            } else if (diffX < 0.005) { // Player collides horizontally
                // Check if player's right side overlaps with monster's left side
                if (player.position.x + Player.WIDTH >= monster.getPosition().x) {
                    game.setScreen(new GameOverScreen(game)); // Player dies, set game over screen
                }
            }
            rectPool.free(monsterRect); // Free monster rectangle from the pool
        }
        rectPool.free(playerRect); // Free player rectangle from the pool
    }


    void pickUpCoins(Player player) {
        Rectangle playerRect = rectPool.obtain();
        playerRect.set(player.position.x, player.position.y, Player.WIDTH, Player.HEIGHT);
        int startX, startY, endX, endY;
        // finds the x-position of the player - both if the player is moving and standing still
        if (player.velocity.x > 0) {
            startX = endX = (int)(player.position.x + Player.WIDTH + player.velocity.x);
        } else {
            startX = endX = (int)(player.position.x + player.velocity.x);
        }
        startY = (int)(player.position.y);
        endY = (int)(player.position.y + Player.HEIGHT);
        getTiles(startX, startY, endX, endY, tiles, coinsLayer);
        // Iterate over the coin rectangles
        for (Rectangle coinRect : tiles) {
            // Check for collision between player and coin
            if (playerRect.overlaps(coinRect)) {
                int cellX = (int) (coinRect.x);
                int cellY = (int) (coinRect.y);

                // Remove the coin from the game
                coinsLayer.setCell(cellX, cellY, null);
                // Increment player's coin score
                player.incrementCoinScore();
                SoundController.getInstance().playCoinSound();
                break; // Exit the loop after picking up one coin
            }
        }
        rectPool.free(playerRect);
    }


    private void checkForPowerUp(Player player) {
        Rectangle playerRect = rectPool.obtain();
        playerRect.set(player.position.x, player.position.y, Player.WIDTH, Player.HEIGHT);
        int startX, startY, endX, endY;
        // finds the x-position of the player - both if the player is moving and standing still
        if (player.velocity.x > 0) {
            startX = endX = (int)(player.position.x + Player.WIDTH + player.velocity.x);
        } else {
            startX = endX = (int)(player.position.x + player.velocity.x);
        }
        startY = (int)(player.position.y);
        endY = (int)(player.position.y + Player.HEIGHT);
        getTiles(startX, startY, endX, endY, tiles, powerUpsLayer);
        // Iterate over the coin rectangles
        for (Rectangle coinRect : tiles) {
            // Check for collision between player and the power up
            if (playerRect.overlaps(coinRect)) {
                int cellX = (int) (coinRect.x);
                int cellY = (int) (coinRect.y);

                // Remove the power up from the game
                powerUpsLayer.setCell(cellX, cellY, null);
                player.powerUp = true;
                SoundController.getInstance().playPowerUpSound();
                break; // Exit the loop after picking up a power up
            }
        }
        rectPool.free(playerRect);
    }


    /**
     * Check for collision in the x-axis.
     * @param unit checks collision for the current unit in regard to the collision layer from the Tiled map.
     */
    private void checkXCollision(IEntity unit) {
        Rectangle playerRect = rectPool.obtain();
        playerRect.set(unit.getPosition().x, unit.getPosition().y, Player.WIDTH, Player.HEIGHT);
        int startX, startY, endX, endY;
        // finds the x-position of the player - both if the player is moving and standing still
        if (unit.getVelocity().x > 0) {
            startX = endX = (int)(unit.getVelocity().x + Player.WIDTH + unit.getVelocity().x);
        } else {
            startX = endX = (int)(unit.getPosition().x + unit.getVelocity().x);
        }
        startY = (int)(unit.getPosition().y);
        endY = (int)(unit.getPosition().y + Player.HEIGHT);
        getTiles(startX, startY, endX, endY, tiles, collisionMap);
        playerRect.x += unit.getVelocity().x;
        for (Rectangle tile : tiles) {
            if (playerRect.overlaps(tile)) {
                unit.getVelocity().x = 0;
                break;
            }
        }
        playerRect.x = unit.getPosition().x;
        rectPool.free(playerRect);
        checkYCollision(unit);
    }


    /**
     * Checks collision in the y-axis for the current unit in regard to the collision layer from the Tiled map.
     * @param unit Current unit you want to check collision for in the game
     */
    private void checkYCollision(IEntity unit) {
        Rectangle playerRect = rectPool.obtain();
        playerRect.set(unit.getPosition().x, unit.getPosition().y, Player.WIDTH, Player.HEIGHT);
        int startX, startY, endX, endY;
        if (unit.getVelocity().y > 0) {
            startY = endY = (int)(unit.getPosition().y + Player.HEIGHT + unit.getVelocity().y);
        } else {
            startY = endY = (int)(unit.getPosition().y + unit.getVelocity().y);
        }
        startX = (int)(unit.getPosition().x);
        endX = (int)(unit.getPosition().x + Player.WIDTH);
        getTiles(startX, startY, endX, endY, tiles, collisionMap);
        playerRect.y += unit.getVelocity().y;
        for (Rectangle tile : tiles) {
            if (playerRect.overlaps(tile)) {
                // we actually reset the players y-position here
                // So its just below/above the tile we collided with this should remove bouncing.

                // If the player jumps up into a block:
                if (unit.getVelocity().y > 0) {
                    unit.getPosition().y = tile.y - Player.HEIGHT;
                    // TODO: implement breaking blocks.
                    // we hit a block jumping upwards, let's destroy it!
                    //collisionMap.setCell((int)tile.x, (int)tile.y, null);
                } else {
                    unit.getPosition().y = tile.y + tile.height;
                    // if we hit the ground, mark us as grounded, so we can jump again
                    unit.setGrounded(true);
                }
                unit.getVelocity().y = 0;
                break;
            }
        }
        rectPool.free(playerRect);
    }


    private void checkPlayerOutOfBounds(Player player) {
        float playerX = player.position.x;
        float playerY = player.position.y;
        float mapWidth = collisionMap.getWidth();
        float mapHeight = collisionMap.getHeight();

        // Check if the player is outside the map boundaries
        if (playerX < -2 || playerY < -2 || playerX > mapWidth || playerY > mapHeight) {
            // Trigger game over event or state
            game.setScreen(new GameOverScreen(game));
        }
    }


    /**
     * Sets the collision map for the model
     * @param collisionLayer The collision map
     */
    public void setCollisionMap(TiledMapTileLayer collisionLayer) {
        this.collisionMap = collisionLayer;
    }


    /**
     * Sets the models power up layer
     * @param powerUps TiledMap layer for where the power ups are placed
     */
    public void setPowerUpLayer(TiledMapTileLayer powerUps) {
        this.powerUpsLayer = powerUps;
    }


    /**
     * Sets the models coin layer
     * @param coinsLayer TiledMap layer for where the coins are placed
     */
    public void setCoinsLayer(TiledMapTileLayer coinsLayer) {
        this.coinsLayer = coinsLayer;
    }


    /**
     * Sets the models start position layer
     * @param startPosLayer TiledMap layer for where the start position is placed
     */
    public void setStartPosLayer(TiledMapTileLayer startPosLayer){
        this.startPosLayer = startPosLayer;
    }


    /**
     * Sets the models end position layer
     * @param endPosLayer TiledMap layer for where the end position is placed
     */
    public void setEndPosLayer(TiledMapTileLayer endPosLayer){
        this.endPosLayer = endPosLayer;
    }


    /**
     * Gets the collision map
     * @return The collision map
     */
    public void getTiles(int startX, int startY, int endX, int endY, Array<Rectangle> tiles, TiledMapTileLayer layer) {
        rectPool.freeAll(tiles);
        tiles.clear();

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                TiledMapTileLayer.Cell cell = layer.getCell(x, y);
                if (cell != null) {
                    Rectangle rect = rectPool.obtain();
                    rect.set(x, y, 1, 1);
                    tiles.add(rect);
                }
            }
        }
    }


    /**
     * Getter for the controller and view to fetch the width of the level.
     * @return width of the level in int.
     */
    public int getLevelWidth() {
        return collisionMap.getWidth();
    }


    /**
     * Gets the player
     * @return The player
     */
    public Player getPlayer() {
        return player;
    }


    /**
     * Gets the monsters
     * @return The monsters
     */
    public ArrayList<Monster> getMonsters() { return monsters; }


    /**
     * Sets the start position for the player
     */
    public void setStartPosition() {
        for (int y = 0; y <= this.startPosLayer.getHeight(); y++) {
            for (int x = 0; x <= this.startPosLayer.getWidth(); x++) {
                TiledMapTileLayer.Cell cell = this.startPosLayer.getCell(x, y);
                if (cell != null) {
                    this.player.setPosition(new Vector2(x, y));
                    setEndPosition();
                    return;
                }
            }
        }
    }


    /**
     * Sets the end position for the player
     */
    public void setEndPosition() {
        for (int y = 0; y <= this.endPosLayer.getHeight(); y++) {
            for (int x = 0; x <= this.endPosLayer.getWidth(); x++) {
                TiledMapTileLayer.Cell cell = this.endPosLayer.getCell(x, y);
                if (cell != null) {
                    this.endPos = new Vector2(x, y);
                    return;
                }
            }
        }
    }


    /**
     * Checks if the player has reached the end position
     * @param player The player
     */
    private void checkEndCollision(Player player) {
        float diffX = Math.abs(player.position.x - endPos.x);
        float diffY = Math.abs(player.position.y - endPos.y);
        if (diffX < 1.0 && diffY < 1.0) {
            game.setScreen(new GameWonScreen(game));
        }
    }
}
