package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.controller.Controller;
import inf112.moustachmania.app.controller.IController;
import inf112.moustachmania.app.model.IModel;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.view.View;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class GameScreenShould {

    private final MoustacheMania game;


    public GameScreenShould() {
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
        GameScreen gameScreen = createScreen();
        gameScreen.pause();
        gameScreen.dispose();
    }

    @Test
    public void pause() {
        GameScreen gameScreen = createScreen();
        gameScreen.resume();
        gameScreen.dispose();
    }

    private GameScreen createScreen() {
        final Model model = new Model(game, new Player());
        final IView view = new View(game, model);
        final IModel model2 = new Model(game, new Player());
        final IController controller = new Controller(game, model);

        return new GameScreen(game, view, controller, model2);
    }
}
