package inf112.moustachmania.app.model.entities;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MushroomFactoryTest {

    MushroomFactory mushroomFactory;

    public MushroomFactoryTest() {
        this.mushroomFactory = new MushroomFactory();
    }

    @Test
    public void testCreateMonsters() {
        ArrayList<Monster> monsters = mushroomFactory.createMonster().getMonsters();
        assertNotNull(monsters);
    }
}
