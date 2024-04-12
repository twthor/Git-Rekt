package inf112.moustachmania.app.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.IModel;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.model.entities.Monster;
import inf112.moustachmania.app.model.entities.Player;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.utils.Constants;
import java.util.ArrayList;
import java.util.Random;


public class View implements IView {

    private final MoustacheMania game;
    private final Model model;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;
    private String currentMapPath;
    private MapLayers mapLayers;
    private final OrthographicCamera camera;
    private Texture playerTexture;
    private Texture coinTexture;
    private Texture powerUpTexture;
    private Texture monsterTexture;
    private Animation<TextureRegion> stand;
    private Animation<TextureRegion> walk;
    private Animation<TextureRegion> jump;
    private Animation<TextureRegion> coinSpin;
    private Animation<TextureRegion> monsterWalk;
    private final int levelNumber;
    Random rand = new Random();
    int numMonsters = rand.nextInt(4);


    public View(MoustacheMania game, Model model, int levelNumber) {
        this.game = game;
        this.model = model;
        this.levelNumber = levelNumber;

        playerTexture = new Texture(Constants.playerTexture);
        TextureRegion[] regions = TextureRegion.split(playerTexture, 16, 16)[0];
        setNormalPlayerTexture();

        // Coins - 0-6
        coinTexture = new Texture(Constants.coinPicture);
        TextureRegion[] coinRegions = TextureRegion.split(coinTexture, 16, 16)[0];
        coinSpin = new Animation<>(0.1f, coinRegions[0], coinRegions[1], coinRegions[2], coinRegions[3], coinRegions[4], coinRegions[5], coinRegions[6]);
        coinSpin.setPlayMode(Animation.PlayMode.LOOP);

        // power up & monster
        powerUpTexture = new Texture(Constants.powerUpTexture);
        monsterTexture = new Texture(Constants.monsterTexture);
        TextureRegion[] monsterRegions = TextureRegion.split(monsterTexture, 16, 16)[0];
        monsterWalk = new Animation<>(0.1f, monsterRegions[0], monsterRegions[1], monsterRegions[2]);
        monsterWalk.setPlayMode(Animation.PlayMode.LOOP);

        // Size of the player - for collision detection
        // 1 unit == 16 pixels
        Player.WIDTH = (1 / 16f) * regions[0].getRegionWidth();
        Player.HEIGHT = (1 / 16f) * regions[0].getRegionHeight();

        loadMap();

        // 30x20 units.
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 30, 20);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);
        tiledMapRenderer.setView(camera);

        setCameraPosition();
        camera.update();

        renderMap();
        renderPlayer();
        renderCoins();
        renderCoinScore();
        renderPowerUps();
        renderMonsters();
    }


    @Override
    public void dispose() {
        playerTexture.dispose();
        tiledMap.dispose();
    }


    private void loadMap() {
        tiledMap = new TmxMapLoader().load(Constants.mapPaths[levelNumber]);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, Constants.scale);
        mapLayers = tiledMap.getLayers();

        TiledMapTileLayer collisionLayer = (TiledMapTileLayer)tiledMap.getLayers().get("collision");
        TiledMapTileLayer coins = (TiledMapTileLayer)tiledMap.getLayers().get("coins");
        TiledMapTileLayer powerUps = (TiledMapTileLayer)tiledMap.getLayers().get("powerUp");
        TiledMapTileLayer startPos = (TiledMapTileLayer)tiledMap.getLayers().get("startPos");
        TiledMapTileLayer endPos = (TiledMapTileLayer)tiledMap.getLayers().get("endPos");

        model.setCollisionMap(collisionLayer);
        model.setCoinsLayer(coins);
        model.setPowerUpLayer(powerUps);
        model.setStartPosLayer(startPos);
        model.setEndPosLayer(endPos);

    }


    private void setCameraPosition() {
        // Get the width of the level
        float levelWidth = model.getLevelWidth();

        // Calculate the minimum and maximum x positions for the camera to stay within the level bounds
        float minX = camera.viewportWidth / 2; // Left edge of the level
        float maxX = levelWidth - camera.viewportWidth / 2; // Right edge of the level

        // Ensure the camera's x position stays within the level bounds
        camera.position.x = Math.max(minX, Math.min(maxX, camera.position.x));

        // Fetches the players x position.
        float playerX = model.getPlayer().position.x;
        // Interpolation is making the camera transition more smoothly.
        float interpolatedX = Interpolation.linear.apply(camera.position.x, playerX, 0.1f);

        // Ensure the interpolated camera position stays within the level bounds
        camera.position.x = Math.max(minX, Math.min(maxX, interpolatedX));
    }


    private void renderPowerUps() {
        TiledMapTileLayer powerUps = (TiledMapTileLayer) mapLayers.get("powerUp");
        ArrayList<Vector2> powerUpPositions = new ArrayList<>();
        float powerUpHeight = 1f;
        float powerUpWidth = 1f;

        for (int i = 0; i < powerUps.getWidth(); i++) {
            for (int j = 0; j < powerUps.getHeight(); j++) {
                TiledMapTileLayer.Cell cell = powerUps.getCell(i, j);
                if (cell != null) {
                    float x = i * powerUpWidth;
                    float y = j * powerUpHeight;
                    Vector2 powerUpPosition = new Vector2(x, y);
                    powerUpPositions.add(powerUpPosition);
                }
            }
            game.getBatch().begin();
            for (Vector2 position : powerUpPositions) {
                game.getBatch().draw(powerUpTexture, position.x, position.y, powerUpWidth, powerUpHeight);
            }
            game.getBatch().end();
        }
    }


    private void renderCoins() {
        Player player = model.getPlayer();
        TiledMapTileLayer coins = (TiledMapTileLayer) mapLayers.get("coins");
        ArrayList<Vector2> coinPositions = new ArrayList<>();
        float coinHeight = 1f;
        float coinWidth = 1f;

        for (int i = 0; i < coins.getWidth(); i++) {
            for (int j = 0; j < coins.getHeight(); j++) {
                TiledMapTileLayer.Cell cell = coins.getCell(i, j);
                if (cell != null) {
                    float x = i * coinWidth;
                    float y = j * coinHeight;
                    Vector2 coinPosition = new Vector2(x, y);
                    coinPositions.add(coinPosition);
                }
            }
        }
        game.getBatch().begin();
        for (Vector2 position : coinPositions) {
            game.getBatch().draw(coinSpin.getKeyFrame(player.stateTime), position.x, position.y, coinWidth, coinHeight);
        }
        game.getBatch().end();
    }


    private void renderCoinScore() {
        Player player = model.getPlayer();
        game.getFont().getData().setScale(0.1f);

        // Calculate the position of the coin score relative to the camera's viewport
        float viewportX = Interpolation.linear.apply(camera.position.x - camera.viewportWidth / 2);
        float viewportY = Interpolation.linear.apply(camera.position.y + camera.viewportHeight / 2);

        // Adjust the position to align with the top-left corner of the screen
        float offsetX = 1;
        float offsetY = camera.viewportHeight - 20;

        // Calculate the position of the coin score in world coordinates
        float worldX = viewportX + offsetX;
        float worldY = viewportY - offsetY;

        game.getBatch().begin();
        game.getFont().draw(game.getBatch(), String.valueOf(player.getCoinScore()), worldX, worldY);
        game.getBatch().end();
    }


    private void renderMap() {
        tiledMapRenderer.render();
    }


    private void renderMonsters() {
        Player player = model.getPlayer();
        ArrayList<Monster> monsters = model.getMonsters();
        //TiledMapTileLayer mapLayer = (TiledMapTileLayer) mapLayers.get("bane");
        float monsterHeight = 1f;
        float monsterWidth = 1f;

        // draw the monsters
        game.getBatch().begin();
        for (Monster monster : monsters) {
            if (monster.isAlive())
                game.getBatch().draw(monsterWalk.getKeyFrame(player.stateTime), monster.getPosition().x, monster.getPosition().y, monsterWidth, monsterHeight);
        }
        game.getBatch().end();
    }


    private void renderPlayer() {
        Player player = model.getPlayer();
        TextureRegion frame = null;
        if (player.powerUp) {
            setPowerUpTexture();
        } else {
            setNormalPlayerTexture();
        }

        // switch-case changing the frames for the player given the state.
        frame = switch (player.state) {
            case Standing -> stand.getKeyFrame(player.stateTime);
            case Walking -> walk.getKeyFrame(player.stateTime);
            case Jumping -> jump.getKeyFrame(player.stateTime);
            default -> frame;
        };

        // draw the player facing either right or left.
        game.getBatch().begin();
        if (player.facesRight) {
            game.getBatch().draw(frame, player.position.x, player.position.y, Player.WIDTH, Player.HEIGHT);
        } else {
            game.getBatch().draw(frame, player.position.x + Player.WIDTH, player.position.y, -Player.WIDTH, Player.HEIGHT);
        }
        game.getBatch().end();
    }


    private void setNormalPlayerTexture() {
        playerTexture = new Texture(Constants.playerTexture);
        TextureRegion[] regions = TextureRegion.split(playerTexture, 16, 16)[0];
        stand = new Animation<>(0, regions[0]);
        walk = new Animation<>(0.1f, regions[1], regions[2], regions[3], regions[4]);
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        jump = new Animation<>(0.1f, regions[5]);
    }


    private void setPowerUpTexture() {
        playerTexture = new Texture(Constants.playerTexturePU);
        TextureRegion[] regions = TextureRegion.split(playerTexture, 16, 16)[0];
        stand = new Animation<>(0, regions[0]);
        walk = new Animation<>(0.1f, regions[1], regions[2], regions[3], regions[4]);
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        jump = new Animation<>(0.1f, regions[5]);
    }


    @Override
    public GameState getGameState() {
        return game.getGameState();
    }
}

