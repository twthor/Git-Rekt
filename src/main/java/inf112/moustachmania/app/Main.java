package inf112.moustachmania.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.moustachmania.app.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Moustache Mania");
        cfg.setWindowedMode(480, 320);

        new Lwjgl3Application(new Controller(), cfg);
    }
}
