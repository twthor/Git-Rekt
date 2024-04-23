package inf112.moustachmania.app.model.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MonsterFactoryTest {

    MonsterFactory monsterFactory;

    public MonsterFactoryTest() {
        this.monsterFactory = new MonsterFactory();
    }

    @Test
    public void testCreateMonsters() {
        ArrayList<Monster> monsters = monsterFactory.createMonsters();
        assertNotNull(monsters);
    }
}
