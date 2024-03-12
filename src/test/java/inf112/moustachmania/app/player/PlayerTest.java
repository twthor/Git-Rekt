package inf112.moustachmania.app.player;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    Player player;

    public PlayerTest() {
        this.player = new Player();
    }

    @Test
    public void testInitialCoinScore() {
        assertEquals(0, player.getCoinScore());
    }

    @Test
    public void incrementScoreTest() {
        player.incrementCoinScore();
        assertEquals(1, player.getCoinScore());
        player.incrementCoinScore();
        assertEquals(2, player.getCoinScore());
    }

    @Test
    public void testSetPowerUp() {
        assertFalse(player.powerUp);
        player.setPowerUp(true);
        assertTrue(player.powerUp);
        player.setPowerUp(false);
        assertFalse(player.powerUp);
    }

    @Test
    public void testPosition() {
        assertEquals(10, player.getPosition().x, 0.01);
        assertEquals(5, player.getPosition().y, 0.01);
        player.setPosition(new Vector2(20, 15));
        assertEquals(20, player.getPosition().x, 0.01);
        assertEquals(15, player.getPosition().y, 0.01);
    }
}
