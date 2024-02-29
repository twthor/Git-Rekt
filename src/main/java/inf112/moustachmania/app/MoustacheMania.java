package inf112.moustachmania.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import inf112.moustachmania.app.screens.GameScreen;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.screens.HelpScreen;
import inf112.moustachmania.app.screens.StartScreen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.moustachmania.app.utils.Consts;

public class MoustacheMania extends Game {

    public StartScreen startScreen;
    public HelpScreen helpScreen;
    private SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;

    // TODO: Soundmanager

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Moustache Mania");
        cfg.setWindowedMode(1000, 800);

        new Lwjgl3Application(new MoustacheMania(), cfg);
     }

    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal(Consts.skinPath));

        this.setScreen(new StartScreen(this));
        //this.setScreen(new HelpScreen(this));
    }

    /**
    */
    public void render() {
        super.render();
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
    }

    public GameState getGameState() {
        if (this.getScreen().getClass() == StartScreen.class) {
            return GameState.START_SCREEN;
        }
        else if (this.getScreen().getClass() == GameScreen.class) {
            return GameState.ACTIVE_GAME;
        }
        else if (this.getScreen().getClass() == HelpScreen.class) {
            return GameState.HelpScreen;
        }
        else {
            throw new RuntimeException("Unkown screen type");
        }

        /*
         TODO: legge til klasser for andre GameStates:

            PAUSE_SCREEN,

            GAME_OVER
                  */

    }

}
