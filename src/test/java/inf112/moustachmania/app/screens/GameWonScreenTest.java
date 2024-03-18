package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameWonScreenTest {

    private static MoustacheMania game;
    private static TestApplication testApp; // Reference to your custom TestApplication

    @BeforeAll
    public static void setup() {
        // Assuming TestApplication correctly initializes your LibGDX environment
        game = new MoustacheMania();
        testApp = new TestApplication(game); // Initialize your game and TestApplication
        game.create();
    }

    @AfterAll
    public static void cleanup() {
        Gdx.app.exit(); // Properly exit and cleanup the LibGDX environment
    }

    @Test
    public void render() {
        GameWonScreen gameWonScreen = new GameWonScreen(game);
        gameWonScreen.render(1);
        gameWonScreen.dispose();
    }

    @Test
    public void pause() {
        GameWonScreen gameWonScreen = new GameWonScreen(game);
        gameWonScreen.pause();
        gameWonScreen.dispose();
    }

    @Test
    public void resume() {
        GameWonScreen gameWonScreen = new GameWonScreen(game);
        gameWonScreen.resume();
        gameWonScreen.dispose();
    }
}
