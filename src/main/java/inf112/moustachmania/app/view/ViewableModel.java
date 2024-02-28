package inf112.moustachmania.app.view;

import inf112.moustachmania.app.screens.GameState;

public interface ViewableModel {

    /**
     * TODO: Legge til javadocs
     */
    void render();

    /**
     * Gets rid of
     */
    void dispose();

    /**
     * Gets the active state of the game
     * @return the current state of the game
     */
    GameState getGameState();


}
