package inf112.moustachmania.app.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.model.entities.Player;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

public class ViewTest {

    private final MoustacheMania game;

    public ViewTest() {
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
        // Arrange
        Model model = new Model(game, new Player());
        IView view = new View(game, model, 1);

        // Act & Assert
        view.render(1);
        view.dispose();
    }

}
