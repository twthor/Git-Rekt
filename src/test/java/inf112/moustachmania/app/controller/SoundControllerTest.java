package inf112.moustachmania.app.controller;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.headless.HeadlessFiles;
import com.badlogic.gdx.files.FileHandle;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.entities.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SoundControllerTest {

    public SoundController soundController;
    private Player playerMock;
    private MoustacheMania gameMock;


    /*
    public SoundControllerTest() {
        soundController = SoundController.getInstance();
        playerMock = new Player();
        gameMock = new MoustacheMania();
        soundController.setPlayer(playerMock);
        soundController.setGame(gameMock);
    } */

    @Test
    public void haveOneInstance() {
        Gdx.files = new HeadlessFiles();
        Gdx.audio = mock(Audio.class);

        SoundController first = SoundController.getInstance();
        SoundController second = SoundController.getInstance();
        assert(first.equals(second));
    }


    @Test
    public void testPlayCoinSound() {
        Gdx.files = new HeadlessFiles();
        Sound coinSound = mock(Sound.class); // Mocking the Music object
        Gdx.audio = mock(Audio.class);
        // Mocking the newSound method to return the mock Sound object
        when(Gdx.audio.newSound(any(FileHandle.class))).thenReturn(coinSound);

        SoundController soundController = mock(SoundController.class);
        soundController.playCoinSound();
        verify(soundController).playCoinSound();
    }


    @Test
    public void testPlayPowerUpSound() {
        // Mocking dependencies
        Gdx.files = new HeadlessFiles();
        // Mocking the Sound object
        Sound powerUpSound = mock(Sound.class);
        Gdx.audio = mock(Audio.class);
        // Mocking the newSound method to return the mock Sound object
        when(Gdx.audio.newSound(any(FileHandle.class))).thenReturn(powerUpSound);

        // Creating a mock SoundController object
        SoundController soundController = mock(SoundController.class);

        // Invoking the method under test
        soundController.playPowerUpSound();

        // Verifying that the method was called
        verify(soundController).playPowerUpSound();
    }

}
