package inf112.moustachmania.app.player;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Player implements ViewableCharacter, ControllablePlayer {

    // field variables
    public static float WIDTH;
    public static float HEIGHT;
    static float MAX_VELOCITY = 10f;
    static float JUMP_VELOCITY = 40f;
    static float DAMPING = 0.87f;
    public float stateTime;

    enum State {
        Standing, Walking, Jumping
    }

    // TODO: implementer getters og setters for disse
    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();
    public State state = State.Walking;

    boolean facesRight = true;
    boolean grounded = false;
    //private boolean goalReached;
    //private boolean powerUp;

    public Player() {
        this.position = new Vector2(10, 5);

        //this.goalReached = false;
        //this.powerUp = false;

        // size of player
        WIDTH = 1 / 16f;
        HEIGHT = 1 / 16f;

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
