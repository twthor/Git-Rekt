package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class LevelScreenTest {

    private final MoustacheMania game;

    public LevelScreenTest() {
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
        LevelScreen levelScreen = createScreen();
        levelScreen.render(1);
        levelScreen.dispose();
    }

    @Test
    public void pause() {
        LevelScreen levelScreen = createScreen();
        levelScreen.pause();
        levelScreen.dispose();
    }

    @Test
    public void resume() {
        LevelScreen levelScreen = createScreen();
        levelScreen.resume();
        levelScreen.dispose();
    }

    private LevelScreen createScreen() {
        return new LevelScreen(game);
    }
}
