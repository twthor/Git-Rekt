package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class GameWonScreenTest {

    private final MoustacheMania game;

    public GameWonScreenTest() {
        this.game = new MoustacheMania();
        new TestApplication(game);

        game.create();
    }

    @AfterClass
    public static void afterAll() {
        Gdx.app.exit();
    }

    @Test
    public void render() {
        GameWonScreen gameWonScreen = createScreen();
        gameWonScreen.render(1);
        gameWonScreen.dispose();
    }

    @Test
    public void pause() {
        GameWonScreen gameWonScreen = createScreen();
        gameWonScreen.pause();
        gameWonScreen.dispose();
    }

    @Test
    public void resume() {
        GameWonScreen gameWonScreen = createScreen();
        gameWonScreen.resume();
        gameWonScreen.dispose();
    }
    private GameWonScreen createScreen() {
        game.levelScreen = new LevelScreen(game);
        game.levelScreen.setCurrentLevel(1);
        return new GameWonScreen(game);
    }

}
