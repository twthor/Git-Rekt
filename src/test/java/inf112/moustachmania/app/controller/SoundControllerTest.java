package inf112.moustachmania.app.controller;

import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.entities.Player;

public class SoundControllerTest {

    public SoundController soundController;
    private Player playerMock;
    private MoustacheMania gameMock;


    public SoundControllerTest() {
        soundController = SoundController.getInstance();
        playerMock = new Player();
        gameMock = new MoustacheMania();
        soundController.setPlayer(playerMock);
        soundController.setGame(gameMock);
    }

    /*
    @Test
    public void testPlayCoinSound() {
        soundController.playCoinSound();
        verify(soundController.playCoinSound());
    }

    @Test
    public void testPlayPowerUpSound() {
        soundController.playPowerUpSound();
        verify(soundController.playPowerUpSound(), times()).play();
    }  */


}
