package inf112.moustachmania.app.controller;

public interface IController {


    /**
     * Updates the controller
     * @param delta time since last update
     */
    void update(float delta);


    /**
     * Disposes of the controller
     */
    void dispose();


    /**
     * Handles player input
     */
    void handleInput();
}
