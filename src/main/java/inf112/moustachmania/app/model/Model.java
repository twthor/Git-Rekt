package inf112.moustachmania.app.model;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.player.Player;

public class Model implements IModel {

    private final Player player;
    private final MoustacheMania game;

    private TiledMapTileLayer collisionMap;
    private Array<Rectangle> tiles = new Array<Rectangle>();
    private final Player player;
    private final MoustacheMania game;
    private static final float GRAVITY = -0.005f;

    private Pool<Rectangle> rectPool = new Pool<Rectangle>() {
        @Override
        protected Rectangle newObject() {
            return new Rectangle();
        }
    };


    public Model(final MoustacheMania game, Player player) {
        this.game = game;
        this.player = player;
    }

    /**
     * Updates the model
     * @param deltaTime The time since the last update
     */
    public void update(float deltaTime) {

        // Continuously try to make player fall
        player.velocity.add(0, GRAVITY);

        // Updating players stateTime. Important for the player animations.
        player.stateTime += deltaTime;

        // Update player position
        player.position.add(player.velocity);

        if (Math.abs(player.velocity.x) < 1) {
            player.velocity.x = 0;
            if (player.grounded) player.state = Player.State.Standing;
        }

        // multiply by delta time so we know how far we go
        // in this frame
        player.velocity.scl(deltaTime);

        // Check for collisions
        // perform collision detection & response, on each axis, but separately
        // if the player is moving right, check the tiles to the right of it's
        // right bounding box edge, otherwise check the ones to the left
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
        getTiles(startX, startY, endX, endY, tiles);
        playerRect.x += player.velocity.x;
        for (Rectangle tile : tiles) {
            if (playerRect.overlaps(tile)) {
                player.velocity.x = 0;
                break;
            }
        }
        playerRect.x = player.position.x;

        if (player.velocity.y > 0) {
            startY = endY = (int)(player.position.y + Player.HEIGHT + player.velocity.y);
        } else {
            startY = endY = (int)(player.position.y + player.velocity.y);
        }
        startX = (int)(player.position.x);
        endX = (int)(player.position.x + Player.WIDTH);
        getTiles(startX, startY, endX, endY, tiles);
        playerRect.y += player.velocity.y;
        for (Rectangle tile : tiles) {
            if (playerRect.overlaps(tile)) {
                // we actually reset the players y-position here
                // So its just below/above the tile we collided with
                // this should remove bouncing.
                if (player.velocity.y > 0) {
                    player.position.y = tile.y - Player.HEIGHT;
                    // TODO: implement breaking blocks.
                    // we hit a block jumping upwards, let's destroy it!
                    //collisionMap.setCell((int)tile.x, (int)tile.y, null);
                } else {
                    player.position.y = tile.y + tile.height;
                    // if we hit the ground, mark us as grounded, so we can jump
                    player.grounded = true;
                }
                player.velocity.y = 0;
                break;
            }
        }
        rectPool.free(playerRect);

        player.position.add(player.velocity);
        player.velocity.scl(1 / deltaTime);
    }


    /**
     * Sets the collision map
     * @param collisionLayer The collision map
     */
    public void setCollisionMap(TiledMapTileLayer collisionLayer) {
        collisionMap = collisionLayer;
    }


    /**
     * Gets the collision map
     * @return The collision map
     */
    public void getTiles(int startX, int startY, int endX, int endY, Array<Rectangle> tiles) {

        rectPool.freeAll(tiles);
        tiles.clear();

        for (int y = startY; y <= endY; y++) {
            for (int x = startX; x <= endX; x++) {
                TiledMapTileLayer.Cell cell = collisionMap.getCell(x, y);
                if (cell != null) {
                    Rectangle rect = rectPool.obtain();
                    rect.set(x, y, 1, 1);
                    tiles.add(rect);
                }
            }
        }
    }


    /**
     * Gets the player
     * @return The player
     */
    public Player getPlayer() {
        return player;
    }
}
