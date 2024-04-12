package inf112.moustachmania.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.screens.*;
import inf112.moustachmania.app.utils.Constants;

public class MoustacheMania extends Game {

    public StartScreen startScreen;
    public LevelScreen levelScreen;
    public HelpScreen helpScreen;
    public GameScreen gameScreen;
    public PauseScreen pauseScreen;
    public GameOverScreen gameOverScreen;
    public GameWonScreen gameWonScreen;
    private SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;
    private SoundController soundController;


    /**
     * Create the game
     */
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
     * Render the game
    */
    public void render() {
        super.render();
        SoundController.getInstance().update();
    }


    /**
     * Get the skin
     */
    public Skin getSkin() {
        return this.skin;
    }


    /**
     * Get the batch
     */
    public SpriteBatch getBatch() {
        return this.batch;
    }


    /**
     * Get the font
     */
    public BitmapFont getFont() {
        return this.font;
    }


    /**
     * Dispose of the game
     */
    public void dispose() {
        batch.dispose();
        font.dispose();
        soundController.dispose();
    }


    /**
     * Get the current game state
     */
    public GameState getGameState() {
        if (this.getScreen().getClass() == StartScreen.class) {
            return GameState.START_SCREEN;
        }
        else if (this.getScreen().getClass() == GameScreen.class) {
            return GameState.ACTIVE_GAME;
        }
        else if (this.getScreen().getClass() == LevelScreen.class) {
            return GameState.LEVEL_SELECT;
        }    
        else if (this.getScreen().getClass() == HelpScreen.class) {
            return GameState.HELP_SCREEN;
        }
        else if (this.getScreen().getClass() == PauseScreen.class) {
            return GameState.PAUSE_SCREEN;
        }
        else if (this.getScreen().getClass() == GameOverScreen.class) {
            return GameState.GAME_OVER;
        }
        else if (this.getScreen().getClass() == GameWonScreen.class) {
            return GameState.GAME_WON;
        }
        else {
            throw new RuntimeException("Unkown screen type");
        }
    }
}
