package inf112.moustachmania.app.view;

import inf112.moustachmania.app.screens.GameState;

public interface IView {


    /**
     * Renders the game, updating the screen
     * @param delta time since last render
     */
    void render(float delta);


    /**
     * Gets rid of the view
     */
    void dispose();


    /**
     * Gets the active state of the game
     * @return the current state of the game
     */
    GameState getGameState();


}
