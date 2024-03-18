package inf112.moustachmania.app.model.entities;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class Monster implements IEntity {

    public static float MAX_VELOCITY = 0.08f;
    private boolean alive;
    private final ArrayList<Monster> monsters;
    public Vector2 position;
    public Vector2 velocity;
    private boolean grounded;

    public static float WIDTH;
    public static float HEIGHT;
    Random rand = new Random();
    public Monster() {
        this.alive = true;
        this.monsters = new ArrayList<>();
        this.position = new Vector2(rand.nextInt(10, 20), 5);
        this.velocity = new Vector2();
        this.grounded = true;

        WIDTH = 1 / 16f;
        HEIGHT = 1 / 16f;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void eliminate(Monster monster) {
        this.alive = false;
        monsters.remove(monster);
    }

    @Override
    public Vector2 getPosition() {
        return this.position;
    }

    @Override
    public Vector2 getVelocity() {
        return this.velocity;
    }

    @Override
    public boolean setGrounded(boolean b) {
        return grounded = b;
    }

    public void setPosition(Vector2 pos) {
        if (pos == position) {
            return;
        }
        this.position = pos;
    }

    public ArrayList<Monster> getNewMonsters() {

        int numMonsters = rand.nextInt(4) + 1; // Generate a random integer between 1 and 4
        for (int i = 0; i < numMonsters; i++) {
            monsters.add(new Monster()); // Add new monsters to the list
        }
        return this.monsters;
    }

    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }
}
