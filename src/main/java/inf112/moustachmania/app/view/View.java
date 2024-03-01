package inf112.moustachmania.app.view;

import java.awt.*;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.utils.Constants;


public class View implements ViewableModel  {

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
    //private final CharacterSprite playerSprite; // TODO: implement texture image for player


    public View(MoustacheMania game, Model model) {
        this.game = game;
        this.model = model;

        // playerSprite = new CharacterSrite(Constants.playerSprite);

        loadMap();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000, 800);
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

        // TODO: split into draw-methods for different layers of the map
        drawMap();

    }

    @Override
    public void dispose() {
        tiledMap.dispose();
    }

    private void loadMap() {
        tiledMap = new TmxMapLoader().load(Constants.mapPaths);
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, Constants.scale);
        mapLayers = tiledMap.getLayers();
        currentMapPath = model.getTileMapPath();
    }
    
    private void drawMap() {
        // start batch
        //tiledMapRenderer.getBatch().begin();

        // render in things from the map:
        tiledMapRenderer.render();
        // TODO: load different layers instead of the whole map in one go.

        // end batch
        //tiledMapRenderer.getBatch().end();
    }

    @Override
    public GameState getGameState() {
        return game.getGameState();
    }
}

