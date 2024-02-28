package inf112.moustachmania.app.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.utils.Consts;


public class View implements ViewableModel  {

    // private final CharacterSprite playerSprite; // TODO: implement texture image for player
    private final MoustacheMania game;
    private final Model model;

    // Map variables
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private String currentMapPath;
    private MapLayers mapLayers;

    public View(MoustacheMania game, Model model, OrthogonalTiledMapRenderer tiledMapRenderer) {
        this.game = game;
        this.model = model;
        this.tiledMapRenderer = tiledMapRenderer;

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        //if (!currentMapPath.equals(model.getTileMapPath)) {
        

    }

    public void dispose() {

    }

    private void loadMap() {
        TiledMap tiledMap = new TmxMapLoader().load("assets/map_1.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 2);
        mapLayers = tiledMap.getLayers();
    }
    
    private void drawMap() {
        
    }

    @Override
    public GameState getGameState() {
        return game.getGameState();
    }
}

