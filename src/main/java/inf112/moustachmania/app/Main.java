package inf112.moustachmania.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.moustachmania.app.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Moustache Mania"); // Updated title to match your game's theme
        cfg.setWindowedMode(480, 320); // You can adjust the window size as needed

        // Instantiate your Controller and pass it to the Lwjgl3Application to start the application
        new Lwjgl3Application(new Controller(), cfg);
    }
}
