package inf112.moustachmania.app.model.entities;

import com.badlogic.gdx.math.Vector2;

public class Player implements IEntity  {

    public Vector2 position;
    public Vector2 velocity;
    public State state = State.Walking;
    public boolean facesRight = true;
    public boolean grounded = true;
    public boolean powerUp = false;
    public static float MAX_VELOCITY = 0.08f;
    public static float JUMP_VELOCITY = 0.12f;
    public float stateTime;
    public static float WIDTH;
    public static float HEIGHT;
    private int coinScore;


    public Player() {
        this.position = new Vector2(10, 5);
        this.stateTime = 0;
        this.coinScore = 0;

        // size of player
        WIDTH = 1 / 16f;
        HEIGHT = 1 / 16f;
        this.velocity = new Vector2();
    }

    public void incrementCoinScore() {
        this.coinScore++;
    }

    public int getCoinScore() {
        return this.coinScore;
    }

    /**
     * Set players power-up boolean
     * @param b true for power-up, false for none.
     */
    public void setPowerUp(boolean b) {
        this.powerUp = b;
    }

    /**
     * The different states the player can be in
     */
    public enum State {
        Standing, Walking, Jumping
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
        return this.grounded = b;
    }

    public void setPosition(Vector2 pos) {
        if (pos == position) {
            return;
        }
        this.position = pos; // x & y
    }
}
