package inf112.moustachmania.app.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.utils.Constants;


public class View implements IView {

    // Game variables
    private final MoustacheMania game;
    private final Model model;

    // Map variables
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private TiledMap tiledMap;
    private String currentMapPath;
    private MapLayers mapLayers;

    // Camera
    private final OrthographicCamera camera;

    // Player variables
    private Texture playerTexture;

    private Animation<TextureRegion> stand;
    private Animation<TextureRegion> walk;
    private Animation<TextureRegion> jump;



    public View(MoustacheMania game, Model model) {
        this.game = game;
        this.model = model;

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
        if (!currentMapPath.equals(model.getTileMapPath())) {
            loadMap();
        }

        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);
        tiledMapRenderer.setView(camera);

        // TODO: implement camera following player and that when it is at the edge, dont fix camera to player
        camera.position.x = model.getPlayer().position.x;
        camera.update();

        // TODO: split into draw-methods for different layers of the map
        renderMap();
        renderPlayer();

    }

    @Override
    public void dispose() {
        playerTexture.dispose();
        tiledMap.dispose();
    }

    private void loadMap() {
        tiledMap = new TmxMapLoader().load(Constants.mapPaths[0]);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, Constants.scale);
        mapLayers = tiledMap.getLayers();
        currentMapPath = model.getTileMapPath();

        TiledMapTileLayer collisionLayer = (TiledMapTileLayer)tiledMap.getLayers().get("collision");
        model.setCollisionMap(collisionLayer);

    }
    
    private void renderMap() {
        // start batch
        //tiledMapRenderer.getBatch().begin();

        // render in things from the map:
        tiledMapRenderer.render();
        // TODO: load different layers instead of the whole map in one go.

        // end batch
        //tiledMapRenderer.getBatch().end();
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

