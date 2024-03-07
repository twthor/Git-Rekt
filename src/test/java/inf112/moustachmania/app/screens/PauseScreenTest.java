package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.player.Player;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class PauseScreenTest {

    private final MoustacheMania game;

    public PauseScreenTest() {
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
        PauseScreen pauseScreen = createScreen();
        pauseScreen.render(1);
        pauseScreen.dispose();
    }

    @Test
    public void pause() {
        PauseScreen pauseScreen = createScreen();
        pauseScreen.pause();
        pauseScreen.dispose();
    }

    @Test
    public void resume() {
        PauseScreen pauseScreen = createScreen();
        pauseScreen.resume();
        pauseScreen.dispose();
    }


    private PauseScreen createScreen() {
        Model model = new Model(game, new Player());
        return new PauseScreen(game, model);
    }

}
