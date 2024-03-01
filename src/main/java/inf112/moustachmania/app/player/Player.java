package inf112.moustachmania.app.player;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Player implements ViewableCharacter, ControllablePlayer {

    // field variables

    // TODO: implementer getters og setters for disse
    public Vector2 position;
    public Vector2 velocity;
    public State state = State.Walking;

    boolean facesRight = true;
    public boolean grounded = true;

    public static float WIDTH;
    public static float HEIGHT;
    static float MAX_VELOCITY = 0.1f;
    static float JUMP_VELOCITY = 0.15f;
    static float DAMPING = 0.87f;
    public float stateTime;

    public Player() {
        this.position = new Vector2(10, 6);

        //this.goalReached = false;
        //this.powerUp = false;

        // size of player
        WIDTH = 1 / 16f;
        HEIGHT = 1 / 16f;
        this.velocity = new Vector2();

    }

    public void movePlayer(int x) {
        velocity.x = x * MAX_VELOCITY;
    }

    public void jumpPlayer() {

        if (grounded) {
            velocity.y += JUMP_VELOCITY;
            grounded = false;
        }
    }

    public enum State {
        Standing, Walking, Jumping
    }


    //private boolean goalReached;
    //private boolean powerUp;

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
