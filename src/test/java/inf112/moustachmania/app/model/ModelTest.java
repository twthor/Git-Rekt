package inf112.moustachmania.app.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.utils.Constants;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ModelTest {

    private Model model;
    private MoustacheMania game;
    private Player player;
    private TiledMap tiledMap = new TmxMapLoader().load(Constants.mapPaths[1]);
    private TiledMapTileLayer collisionMap = (TiledMapTileLayer)tiledMap.getLayers().get("collision");
    private TiledMapTileLayer coinsLayer = (TiledMapTileLayer)tiledMap.getLayers().get("coins");
    private TiledMapTileLayer powerUpsLayer = (TiledMapTileLayer)tiledMap.getLayers().get("powerUp");

    public ModelTest() {
        this.player = new Player();
        this.game = new MoustacheMania();
        this.model = new Model(game, player);

        model.setCollisionMap(collisionMap);
        model.setPowerUpLayer(powerUpsLayer);
        model.setCoinsLayer(coinsLayer);
    }

    @Test
    public void TestPlayerMovement() {
        assertEquals(10, model.getPlayer().getPosition().x);
        model.movePlayer(2);
        assertEquals(12, model.getPlayer().getPosition().x);
    }
}
