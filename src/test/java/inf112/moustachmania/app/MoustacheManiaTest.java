package inf112.moustachmania.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.TestApplication;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.screens.GameState;
import org.junit.AfterClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class MoustacheManiaTest {

    @Mock
    SoundController soundControllerMock;

    private MoustacheMania game;


    public MoustacheManiaTest() {
        game = new MoustacheMania();
        soundControllerMock = mock(SoundController.class);
        soundControllerMock.setGame(game);

        new TestApplication(game);
    }

    @AfterClass
    public static void afterAll() {
        Gdx.app.exit();
    }

    @Test
    public void render() {
        MoustacheMania game = new MoustacheMania();
        soundControllerMock = mock(SoundController.class);
        soundControllerMock.setGame(game);

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

    @Test
    public void returnBatch() {
        MoustacheMania game = new MoustacheMania();

        game.create();
        assertNotNull(game.getBatch());
        game.dispose();
    }

    @Test
    public void returnSkin() {
        MoustacheMania game = new MoustacheMania();

        game.create();
        assertNotNull(game.getSkin());
        game.dispose();
    }

    @Test
    public void returnGameState() {
        MoustacheMania game = new MoustacheMania();

        game.create();
        assertEquals(GameState.START_SCREEN, game.getGameState());
        game.dispose();
    }

}
