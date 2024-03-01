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
    boolean grounded = false;

    public static float WIDTH;
    public static float HEIGHT;
    static float MAX_VELOCITY = 10f;
    static float JUMP_VELOCITY = 40f;
    static float DAMPING = 0.87f;
    public float stateTime;

    public void movePlayer(int x, int y) {
        position.x += x;
        position.y += y;
        System.out.println("Player moved to: " + position.x + ", " + position.y);
    }



    enum State {
        Standing, Walking, Jumping
    }


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
