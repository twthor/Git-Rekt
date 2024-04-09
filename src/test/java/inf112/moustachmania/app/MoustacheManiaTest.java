package inf112.moustachmania.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MoustacheManiaTest {
    public MoustacheManiaTest() {
        new TestApplication(new MoustacheMania());
    }

    @AfterClass
    public static void afterAll() {
        Gdx.app.exit();
    }

    @Test
    public void render() {
        MoustacheMania game = new MoustacheMania();
        game.create();
        game.render();
        game.dispose();
    }

    @Test
    public void returnFont() {
        MoustacheMania game = new MoustacheMania();
        game.create();
        assertNotNull(game.getFont());
        game.dispose();
    }

}
