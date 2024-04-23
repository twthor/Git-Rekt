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
    public boolean movesRight;
    public Vector2 startPosition;

    public static float WIDTH;
    public static float HEIGHT;
    private int monsterId;
    Random rand = new Random();


    public Monster(int monsterId) {
        this.alive = true;
        this.monsters = new ArrayList<>();
        this.position = new Vector2(rand.nextInt(10, 20), 5);
        this.velocity = new Vector2();
        this.grounded = true;
        this.startPosition = new Vector2(position.x, 5);
        this.monsterId = monsterId;

        WIDTH = 1 / 16f;
        HEIGHT = 1 / 16f;
    }


    /**
     * Checks if the monster is alive
     */
    public boolean isAlive() {
        return this.alive;
    }


    /**
     * Eliminates the monster
     * @param monster the monster to eliminate
     */
    public void eliminate(Monster monster) {
        monsters.remove(monster); // removing it from the list to prevent the player from colliding with a dead monster
        this.alive = false; // so the view know not to draw the monster anymore.
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
    public void setGrounded(boolean b) {
        this.grounded = b;
    }


    /**
     * Checks if the monster is grounded
     */
    public boolean getGrounded() {
        return this.grounded;
    }

    // TODO: skrive test
    /**
     * Gives you the ID of what kind of monster it is.
     * @return int ID of monster type.
     */
    public int getMonsterId() {
        return this.monsterId;
    }

    /**
     * Sets the position of the monster
     * @param pos the position to set
     */
    public void setPosition(Vector2 pos) {
        if (pos == position) {
            return;
        }
        this.position = pos;
    }

    /**
     * Gets the monsters
     */
    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }
}
