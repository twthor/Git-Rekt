package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class GameOverScreenTest {

    private final MoustacheMania game;


    public GameOverScreenTest() {
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
        GameOverScreen gameOverScreen = createScreen();
        gameOverScreen.render(1);
        gameOverScreen.dispose();
    }

    @Test
    public void pause() {
        GameOverScreen gameOverScreen = createScreen();
        gameOverScreen.pause();
        gameOverScreen.dispose();
    }

    @Test
    public void resume() {
        GameOverScreen gameOverScreen = createScreen();
        gameOverScreen.resume();
        gameOverScreen.dispose();
    }
    private GameOverScreen createScreen() {
        game.levelScreen = new LevelScreen(game);
        game.levelScreen.setCurrentLevel(2);
        return new GameOverScreen(game);
    }

}
