package inf112.moustachmania.app.controller;

public interface ControllableModel {

    /**
     * Sets the GameState to GAME_OVER
     */
    void setGameOver();

    /**
     * Sets the time between each tick in milliseconds
     * @return the time in milliseconds between each tick.
     */
    int timeBetweenTick();

    /**
     * Called everytime the timer ticks.
     * Used when updating the model.
     */
    void clockTick();

    /**
     * Checks to see if the player is moving
     * @return true if player is moving
     */
    boolean isMoving();

    /**
     * Starts the game by setting GameState to ActiveGame
     */
    void startGame();
}
