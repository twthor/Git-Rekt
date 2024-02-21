package inf112.moustachmania.app.model;

import com.badlogic.gdx.graphics.Texture;
import inf112.moustachmania.app.Screens.GameState;
import inf112.moustachmania.app.controller.ControllableModel;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.view.ViewableModel;

import java.awt.*;

public class Model implements ViewableModel, ControllableModel {

    // Field variables
    private Player player;

    public Rectangle spriteRect;
    public float dx = 1, dy = 1;
    public GameState state;
    private final Rectangle screenRect = new Rectangle();

    public Model(Texture spriteImage) {
        spriteRect = new Rectangle(1, 1, spriteImage.getWidth() / 2, spriteImage.getHeight() / 2);
        this.state = GameState.START_SCREEN;
    }

    public void updateScreenSize(int width, int height) {
        screenRect.width = width;
        screenRect.height = height;
    }

    public void updatePosition() {
        Rectangle tempRectX = new Rectangle(spriteRect);
        tempRectX.x += (int) dx; // Forsøke å gå i X retning

        // Sjekke ny posisjon er innenfor skjermen
        if (screenRect.contains(tempRectX)) {
            spriteRect.x += (int) dx; // Dersom innenfor skjermen, forsøk å bevege seg.
        } else {
            dx = -dx; // motsatt retning om ikke innenfor skjermen
        }

        // Samme som for X-retning, men her for Y-retning
        Rectangle tempRectY = new Rectangle(spriteRect);
        tempRectY.y += (int) dy;

        if (screenRect.contains(tempRectY)) {
            spriteRect.y += (int) dy;
        } else {
            dy = -dy;
        }
    }

    @Override
    public void setGameOver() {

    }

    @Override
    public int timeBetweenTick() {
        return 0;
    }

    @Override
    public void clockTick() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public GameState getGameState() {
        return state;
    }
}
