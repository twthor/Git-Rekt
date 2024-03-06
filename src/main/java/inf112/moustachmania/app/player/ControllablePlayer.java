package inf112.moustachmania.app.player;

import com.badlogic.gdx.math.Vector2;


public interface ControllablePlayer {

    /**
     * Gets the position of the Player.
     * @return array of x and y coordinates of the player.
     */
    Vector2 getPosition();

    /**
     * Updates the position of the player.
     * @param pos array of the new x and y coordinates of the player.
     */
    void setPosition(Vector2 pos);


}
