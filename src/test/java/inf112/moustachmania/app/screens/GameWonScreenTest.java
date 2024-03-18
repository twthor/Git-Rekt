package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import inf112.moustachmania.app.MoustacheMania;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameWonScreenTest {

    private static MoustacheMania game;
    private static HeadlessApplication application;

    @BeforeAll
    public static void setUp() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        game = new MoustacheMania();
        application = new HeadlessApplication(game, config);
        // Since you're running in a headless environment, game.create() is not necessary if your game's
        // initialization happens within the MoustacheMania constructor or the create method triggered by the application.
    }

    @AfterAll
    public static void afterAll() {
        if (application != null) {
            application.exit();
            application = null;
        }
        // Ensure LibGDX's application reference is cleaned up.
        Gdx.app = null;
    }

    @Test
    public void render() {
        GameWonScreen gameWonScreen = createScreen();
        // Simulate rendering
        gameWonScreen.render(1f);
        // Ensure to dispose of resources to prevent memory leaks
        gameWonScreen.dispose();
    }

    @Test
    public void pause() {
        GameWonScreen gameWonScreen = createScreen();
        gameWonScreen.pause();
        gameWonScreen.dispose();
    }

    private GameWonScreen createScreen() {
        // Return a new instance of GameWonScreen
        return new GameWonScreen(game);
    }
}
