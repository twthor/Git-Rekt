package inf112.moustachmania.app.player;

public interface ControllablePlayer {
    /**
     * Gets the position of the Player.
     * @return array of x and y coordinates of the player.
     */
    int[] getPosition();

    /**
     * Updates the position of the player.
     * @param pos array of the new x and y coordinates of the player.
     */
    void setPosition(int[] pos);

    /**
     *
     * @param pos
     */
    void setDestination(int[] pos);

    /**
     * Checks if the player reached the goal in the game.
     * @return true if the player has reached the goal
     */
    boolean goalReached();

    /**
     * Checks if the player currently have a power up or not.
     * @return true if the player has a power up.
     */
    boolean havePowerUp();

    /**
     * Used to set current power up status for the player.
     */
    void updatePowerUpStatus(boolean status);

}
