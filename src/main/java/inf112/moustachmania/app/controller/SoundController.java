package inf112.moustachmania.app.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.screens.GameState;

public class SoundController {

    GameState currentGameState;
    private Player player;
    private MoustacheMania game;
    private final Music backgroundMusic;
    private final Music mainMenuMusic;
    private final Sound coinSound;
    private final Sound gameOverSound;
    private final Sound levelCompletedSound;
    private final Sound powerUpSound;
    private static SoundController instance = null;


    private SoundController() {
        // LibGDX filepath finding API
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
        mainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("mainMenuMusic.mp3"));
        coinSound = Gdx.audio.newSound(Gdx.files.internal("coinSound.mp3"));
        gameOverSound = Gdx.audio.newSound(Gdx.files.internal("gameOver.wav"));
        levelCompletedSound = Gdx.audio.newSound(Gdx.files.internal("levelCompleted.wav"));
        powerUpSound = Gdx.audio.newSound(Gdx.files.internal("powerUpSound.mp3"));
    }


    /**
     * Singleton pattern
     * @return The instance of the SoundController
     */
    public static SoundController getInstance() {
        if (instance == null) {
            instance = new SoundController();
        }
        return instance;
    }


    /**
     * Updates the music and sound effects based on GameStates and game events
     */
    public void update() {
        if (game == null){
            return;
        }

        GameState gameState = game.getGameState();

        if (gameState == currentGameState){
            return;
        }

        if (gameState == GameState.ACTIVE_GAME) {
            backgroundMusic.setVolume(0.3f);
            backgroundMusic.setLooping(true);
            backgroundMusic.play();

            /*
            if (player.powerUp) {
                powerUpSound.play();
            } */
        } else {
            backgroundMusic.stop();
        }

        if (gameState == GameState.PAUSE_SCREEN) {
            backgroundMusic.stop();
        }

        if (gameState == GameState.START_SCREEN || gameState == GameState.HELP_SCREEN || gameState == GameState.LEVEL_SELECT) {
            mainMenuMusic.setLooping(true);
            mainMenuMusic.play();
        } else {
            mainMenuMusic.stop();
        }

        if (gameState == GameState.GAME_OVER) {
            gameOverSound.play();
        }
        if (gameState == GameState.GAME_WON) {
            levelCompletedSound.play();
        }

        currentGameState = gameState;
    }

    public void playCoinSound() {
        coinSound.play();
    }

    public void playPowerUpSound() {
        powerUpSound.play();
    }

    /**
     * Sets the player instance to be used by the SoundController.
     * @param player The player instance to be set.
     */
    public void setPlayer(Player player) {
        this.player = player;
    }


    /**
     * Sets the game instance to be used by the SoundController.
     * @param game The game instance to be set.
     */
    public void setGame(MoustacheMania game) {
        this.game = game;
    }


    /**
     * Disposes of the music and sound effects
     */
    public void dispose() {
        backgroundMusic.dispose();
        mainMenuMusic.dispose();
        coinSound.dispose();
        gameOverSound.dispose();
        levelCompletedSound.dispose();
    }

}
