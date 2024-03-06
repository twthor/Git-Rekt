package inf112.moustachmania.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.screens.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.moustachmania.app.utils.Constants;

public class MoustacheMania extends Game {

    public StartScreen startScreen;
    public HelpScreen helpScreen;
    public GameScreen gameScreen;
    public PauseScreen pauseScreen;

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
        //this.setScreen(new HelpScreen(this));
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
        else if (this.getScreen().getClass() == HelpScreen.class) {
            return GameState.HELP_SCREEN;
        }
        else if (this.getScreen().getClass() == PauseScreen.class) {
            return GameState.PAUSE_SCREEN;
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
