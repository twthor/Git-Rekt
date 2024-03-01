package inf112.moustachmania.app.model;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.model.map.MapController;

public class Model implements IModel {

    // Field variables
    private final Player player;

    private final MoustacheMania game;
    private final MapController mapController;

    private TiledMapTileLayer collisionMap;

    private static final float GRAVITY = -2.5f;


    public Model(final MoustacheMania game, Player player) {
        this.game = game;
        this.player = player;
        this.mapController = MapController.getInstance();
    }

    public void updateScreenSize(int width, int height) {

    }

    public void updatePosition() {

    }

    
    public void setCollisionMap(TiledMapTileLayer collisionLayer) {
        // mapController.setCollisionMap(collisionLayer);

    }

    public Player getPlayer() {
        return player;
    }


    public String getTileMapPath() {
        return mapController.getTileMapPath();
    }


}
