package inf112.moustachmania.app.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.screens.GameState;

public class SoundController {

    private Player player;
    private final Music backgroundMusic;
    private final Music mainMenuMusic;
    private final Sound powerUpSound;
    private MoustacheMania game;
    private static SoundController instance = null;
    GameState currentGameState;


    private SoundController() {
        // LibGDX filepath finding API
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundMusic.mp3"));
        mainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("mainMenuMusic.mp3"));
        powerUpSound = Gdx.audio.newSound(Gdx.files.internal("powerUpSound.mp3"));
    }

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

            if (player.powerUp) {
                powerUpSound.play();
            }
        } else {
            backgroundMusic.stop();
        }
        if (gameState == GameState.PAUSE_SCREEN) {
            backgroundMusic.stop();
        }
        if (gameState == GameState.START_SCREEN) {
            mainMenuMusic.setLooping(true);
            mainMenuMusic.play();
        } else {
            mainMenuMusic.stop();
        }


        currentGameState = gameState;
    }

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

    public void dispose() {
        backgroundMusic.dispose();
        mainMenuMusic.dispose();
        powerUpSound.dispose();
    }

}
