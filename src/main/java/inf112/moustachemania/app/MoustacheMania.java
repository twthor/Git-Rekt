package inf112.moustachemania.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import inf112.moustachemania.app.controller.SoundController;
import inf112.moustachemania.app.screens.GameScreen;
import inf112.moustachemania.app.screens.GameState;
import inf112.moustachemania.app.screens.StartScreen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.moustachemania.app.utils.Constants;

public class MoustacheMania extends Game {

    public StartScreen startScreen;
    public GameScreen gameScreen;
    private SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;
    private SoundController soundController;

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Moustache Mania");
        cfg.setWindowedMode(1000, 800);

        new Lwjgl3Application(new MoustacheMania(), cfg);
     }

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal(Constants.skinPath));

        // Sound-controller
        soundController = SoundController.getInstance();
        soundController.setGame(this);

        this.setScreen(new StartScreen(this));
    }

    /**
    */
    public void render() {
        super.render();
        SoundController.getInstance().update();
    }

    public Skin getSkin() {
        return this.skin;
    }

    public SpriteBatch getBatch() {
        return this.batch;
    }

    public BitmapFont getFont() {
        return this.font;
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        soundController.dispose();
    }

    public GameState getGameState() {
        if (this.getScreen().getClass() == StartScreen.class) {
            return GameState.START_SCREEN;
        }
        else if (this.getScreen().getClass() == GameScreen.class) {
            return GameState.ACTIVE_GAME;
        }
        else {
            throw new RuntimeException("Unkown screen type");
        }

        /*
         TODO: legge til klasser for andre GameStates:
            PAUSE_SCREEN,
            GAME_OVER
            HELP_SCREEN
         */

    }

}
