package inf112.moustachmania.app.model.entities;

import com.badlogic.gdx.math.Vector2;

public interface IEntity {


    Vector2 getPosition();

    Vector2 getVelocity();

    boolean setGrounded(boolean b);
}
