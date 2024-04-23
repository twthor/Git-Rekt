package inf112.moustachmania.app.model.entities;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {

    Monster monster;

    public MonsterTest() {
        this.monster = new Monster(1);
    }

    /**
     * Since the monsters are assigned a random x value we need to test
     * the position differently
     */
    @Test
    public void testPosition() {
        // Making sure the monster got a random x position
        assertNotNull(monster.getPosition());

        monster.setPosition(new Vector2(10, 5));
        assertEquals(10, monster.getPosition().x);
        assertEquals(5, monster.getPosition().y);
    }

    @Test
    public void testMonsterId() {
        assertEquals(1, monster.getMonsterId());
    }

    @Test
    public void testVelocity() {
        assertNotNull(monster.getVelocity());
        monster.velocity.x = 1;
        assertEquals(1, monster.getVelocity().x);
    }

    @Test
    public void testIsAlive() {
        assertTrue(monster.isAlive());
        monster.eliminate(monster);
        assertFalse(monster.isAlive());
    }

    @Test
    public void testGrounded() {
        assertTrue(monster.getGrounded());
        monster.setGrounded(false);
        assertFalse(monster.getGrounded());
    }

    @Test
    public void getMonsters() {
        assertNotNull(monster.getMonsters());
    }

}
