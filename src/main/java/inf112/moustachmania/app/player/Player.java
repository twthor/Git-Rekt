package inf112.moustachmania.app.player;

import com.badlogic.gdx.math.Vector2;

public class Player implements ViewableCharacter, ControllablePlayer {

    public Vector2 position;
    public Vector2 velocity;
    public State state = State.Walking;
    public boolean facesRight = true;
    public boolean grounded = true;
    public boolean powerUp = false;
    static float MAX_VELOCITY = 0.1f;
    static float JUMP_VELOCITY = 0.15f;
    public float stateTime;
    public static float WIDTH;
    public static float HEIGHT;


    public Player() {
        this.position = new Vector2(10, 6);
        this.stateTime = 0;

        // size of player
        WIDTH = 1 / 16f;
        HEIGHT = 1 / 16f;
        this.velocity = new Vector2();

    }


    /**
     * Moves the player in the x-axis
     * @param x the direction the player should move
     */
    public void movePlayer(int x) {
        velocity.x = x * MAX_VELOCITY;
    }


    /**
     * Makes the player jump
     */
    public void jumpPlayer() {
        if (grounded) {
            velocity.y += JUMP_VELOCITY;
            grounded = false;
        }
    }


    /**
     * The different states the player can be in
     */
    public enum State {
        Standing, Walking, Jumping
    }


    @Override
    public Vector2 getPosition() {
        return position;
    }


    @Override
    public void setPosition(Vector2 pos) {
        if (pos == position) {
            return;
        }
        this.position = pos; // x & y
    }
}
