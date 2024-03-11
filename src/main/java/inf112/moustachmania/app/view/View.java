package inf112.moustachmania.app.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.utils.Constants;

import static com.badlogic.gdx.Gdx.graphics;


public class View implements IView {

    private final MoustacheMania game;
    private final Model model;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;
    private String currentMapPath;
    private MapLayers mapLayers;
    private final OrthographicCamera camera;
    private Texture playerTexture;
    private Animation<TextureRegion> stand;
    private Animation<TextureRegion> walk;
    private Animation<TextureRegion> jump;
    private final int levelNumber;


    public View(MoustacheMania game, Model model, int levelNumber) {
        this.game = game;
        this.model = model;
        this.levelNumber = levelNumber;

        playerTexture = new Texture("assets/karakter.png");
        TextureRegion[] regions = TextureRegion.split(playerTexture, 16, 16)[0];
        stand = new Animation<>(0, regions[0]);
        walk = new Animation<>(0.1f, regions[1], regions[2], regions[3], regions[4]);
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        jump = new Animation<>(0.1f, regions[5]);

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
        model.setCollisionMap(collisionLayer);
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
    
    private void renderMap() {
        tiledMapRenderer.render();
    }

    private void renderPlayer() {
        Player player = model.getPlayer();
        TextureRegion frame = null;

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

    @Override
    public GameState getGameState() {
        return game.getGameState();
    }
}

