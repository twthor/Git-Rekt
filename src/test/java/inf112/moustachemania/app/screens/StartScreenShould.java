package inf112.moustachemania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachemania.app.MoustacheMania;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class StartScreenShould {

    private final MoustacheMania game;

    public StartScreenShould() {
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
        StartScreen startScreen = createScreen();
        startScreen.render(1);
        startScreen.dispose();
    }

    @Test
    public void pause() {
        StartScreen startScreen = createScreen();
        startScreen.pause();
        startScreen.dispose();
    }

    @Test
    public void resume() {
        StartScreen startScreen = createScreen();
        startScreen.resume();
        startScreen.dispose();
    }

    private StartScreen createScreen() {
        return new StartScreen(game);
    }

}
