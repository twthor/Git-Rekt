package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class HelpScreenTest {

    private final MoustacheMania game;

    public HelpScreenTest() {
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
        HelpScreen helpScreen = createScreen();
        helpScreen.render(1);
        helpScreen.dispose();
    }

    @Test
    public void pause() {
        HelpScreen helpScreen = createScreen();
        helpScreen.pause();
        helpScreen.dispose();
    }

    @Test
    public void resume() {
        HelpScreen helpScreen = createScreen();
        helpScreen.resume();
        helpScreen.dispose();
    }

    private HelpScreen createScreen() {
        return new HelpScreen(game);
    }

}
