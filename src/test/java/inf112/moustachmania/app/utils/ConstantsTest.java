package inf112.moustachmania.app.utils;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class ConstantsTest {

    @Test
    public void testSkinPath() {
        assertTrue(Files.exists(Path.of(Constants.skinPath)));
    }

    @Test
    public void testMapPaths() {
        for (String mapPath : Constants.mapPaths) {
            assertTrue(Files.exists(Path.of(mapPath)));
        }
    }

    @Test
    public void testScale() {
        assertEquals(1 / 16f, Constants.scale);
    }

    @Test
    public void testBackgroundPicture() {
        assertTrue(Files.exists(Path.of(Constants.backgroundPicture)));
    }

    @Test
    public void testLogoPicture() {
        assertTrue(Files.exists(Path.of(Constants.logoPicture)));
    }

    @Test
    public void testGameOverPicture() {
        assertTrue(Files.exists(Path.of(Constants.gameOverPicture)));
    }

    @Test
    public void testCoinPicture() {
        assertTrue(Files.exists(Path.of(Constants.coinPicture)));
    }

    @Test
    public void testPlayerTexture() {
        assertTrue(Files.exists(Path.of(Constants.playerTexture)));
    }

    @Test
    public void testPlayerTexturePU() {
        assertTrue(Files.exists(Path.of(Constants.playerTexturePU)));
    }

    @Test
    public void testPowerUpTexture() {
        assertTrue(Files.exists(Path.of(Constants.powerUpTexture)));
    }

    @Test
    public void testMonsterTexture() {
        assertTrue(Files.exists(Path.of(Constants.monsterTexture)));
    }

    @Test
    public void testLevelScreenBackground() {
        assertTrue(Files.exists(Path.of(Constants.levelScreenBackground)));
    }

    @Test
    public void testGameWonScreenBackground() {
        assertTrue(Files.exists(Path.of(Constants.gameWonScreenBackground)));
    }


}

