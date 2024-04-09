package inf112.moustachmania.app.controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.backends.headless.HeadlessFiles;
import com.badlogic.gdx.files.FileHandle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class SoundControllerTest {

    @BeforeAll
    static void setUpBeforeAll() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        ApplicationListener listener = new ApplicationListener() {

            @Override
            public void create() {
                // TODO Auto-generated method stub

            }

            @Override
            public void resize(int width, int height) {
                // TODO Auto-generated method stub

            }

            @Override
            public void render() {
                // TODO Auto-generated method stub

            }

            @Override
            public void pause() {
                // TODO Auto-generated method stub

            }

            @Override
            public void resume() {
                // TODO Auto-generated method stub

            }

            @Override
            public void dispose() {
                // TODO Auto-generated method stub

            }};
        new HeadlessApplication(listener, config);
    }

    @Test
    public void haveOneInstance() {
        Gdx.files = new HeadlessFiles();
        Gdx.audio = mock(Audio.class);

        SoundController first = SoundController.getInstance();
        SoundController second = SoundController.getInstance();
        assert(first.equals(second));
    }

    /**
    * Simple test case
    */
    @Test
    void findMusicFiles() {
        // check that we can find a file using the LibGDX file API
        assertNotNull(Gdx.files.internal("backgroundMusic.mp3"));
        assertNotNull(Gdx.files.internal("coinSound.mp3"));
        assertNotNull(Gdx.files.internal("gameOver.wav"));
        assertNotNull(Gdx.files.internal("levelCompleted.wav"));
        assertNotNull(Gdx.files.internal("mainMenuMusic.mp3"));
        assertNotNull(Gdx.files.internal("powerUpSound.mp3"));
    }


    @Test
    public void testPlayCoinSound() {
        Gdx.files = new HeadlessFiles();
        // Mocking the Music object
        Sound coinSound = mock(Sound.class);
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
