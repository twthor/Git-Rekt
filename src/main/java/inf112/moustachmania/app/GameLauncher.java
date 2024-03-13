package inf112.moustachmania.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class GameLauncher {

    public static void main (String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Moustache Mania");
        config.setWindowedMode(1000, 800);
        config.useVsync(true);
        config.setForegroundFPS(60);

        new Lwjgl3Application(new MoustacheMania(), config);
    }
}
