package inf112.moustachemania.app.controller;

public interface IController {

    void update(float delta);

    void dispose();

    /**
     * Sets the GameState to GAME_OVER
     */
    void setGameOver();

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

    void handleInput();
}
