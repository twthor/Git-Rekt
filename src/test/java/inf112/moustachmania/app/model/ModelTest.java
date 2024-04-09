package inf112.moustachmania.app.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Vector2;
import inf112.moustachmania.app.model.entities.Player;
import inf112.moustachmania.app.utils.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class ModelTest {

    private Model model;
    private Player player;
    private TiledMapTileLayer collisionLayer;

    @BeforeEach
    public void setUp() {
        player = new Player();
        // Since test files struggle to load the map.tmx files, we have created a dummy map for testing purpoes:
        collisionLayer = new TiledMapTileLayer(10, 10, 16, 16);
        model = new Model(null, player);
        model.setCollisionMap(collisionLayer);
    }

    @Test
    public void testPlayerMovement() {
        assertEquals(10, model.getPlayer().getPosition().x);
        model.movePlayer(1); // Move the player to the right
        assertEquals(10+Player.MAX_VELOCITY, model.getPlayer().getPosition().x);
    }

    @Test
    public void testPlayerJump() {
        model.jumpPlayer();
        assertTrue(model.getPlayer().getVelocity().y > 0); // Assuming player jumps upwards
    }

    /*
    @Test
    public void testPickUpCoins() {
        // Assuming there are coins in the collision layer at position (1, 1)
        TiledMapTileLayer coinsLayer = new TiledMapTileLayer(30, 10, 16, 16);
        TiledMapTile tiledMapTile = mock(TiledMapTile.class);
        TiledMapTileLayer.Cell coinCell = new TiledMapTileLayer.Cell().setTile(tiledMapTile);
        assertNotNull(coinCell.getTile());

        coinsLayer.setCell(11, 5, coinCell);

        model.setCoinsLayer(coinsLayer);

        // Original position
        model.getPlayer().setPosition(new Vector2(10, 5));

        // Before picking up coins, player's coin score should be 0
        assertEquals(0, model.getPlayer().getCoinScore());

        // put the player on top of the coin
        model.movePlayer(13);
        System.out.println(player.getPosition());

        // Call the method to pick up coins
        model.pickUpCoins(model.getPlayer());

        // After picking up coins, player's coin score should increase by 1
        assertEquals(1, model.getPlayer().getCoinScore());

        // Verify that the coin cell is removed from the coins layer
        assertNull(coinsLayer.getCell(11, 5));
    } */


}
