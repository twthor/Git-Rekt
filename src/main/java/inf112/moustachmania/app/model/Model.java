package inf112.moustachmania.app.model;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Model {
    public Rectangle spriteRect;
    public float dx = 1, dy = 1;
    private final Rectangle screenRect = new Rectangle();

    public Model(Texture spriteImage) {
        spriteRect = new Rectangle(1, 1, spriteImage.getWidth() / 2, spriteImage.getHeight() / 2);
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

}
