package inf112.moustachmania.app.model.entities;

import java.util.ArrayList;
import java.util.Random;

public class MonsterFactory {

    public ArrayList<Monster> createMonsters() {
        ArrayList<Monster> monsters = new ArrayList<>();
        int numMonsters = getRandomInt(5);
        for (int i = 0; i < numMonsters; i++) {
            monsters.add(new Monster(getRandomInt(2)));
        }
        return monsters;
    }

    private int getRandomInt(int range) {
        Random rand = new Random();
        return rand.nextInt(range) + 1;
    }
}
