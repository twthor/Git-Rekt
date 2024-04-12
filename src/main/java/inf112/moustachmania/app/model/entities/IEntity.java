package inf112.moustachmania.app.model.entities;

import com.badlogic.gdx.math.Vector2;

public interface IEntity {


    /**
     * Gets the position of the entity
     */
    Vector2 getPosition();


    /**
     * Gets the velocity of the entity
     */
    Vector2 getVelocity();


    /**
     * Sets the velocity of the entity
     */
    void setGrounded(boolean b);
}
