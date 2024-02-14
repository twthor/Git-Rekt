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
        // Create a new rectangle to represent the sprite's potential new position for X movement
        Rectangle tempRectX = new Rectangle(spriteRect);
        tempRectX.x += (int) dx; // Attempt to move in the X direction

        // Check if the new position is within the screen bounds in the X direction
        if (screenRect.contains(tempRectX)) {
            spriteRect.x += (int) dx; // Apply movement if within bounds
        } else {
            dx = -dx; // Reverse direction if out of bounds
        }

        // Create a new rectangle for the Y movement, similar to the X direction
        Rectangle tempRectY = new Rectangle(spriteRect);
        tempRectY.y += (int) dy; // Attempt to move in the Y direction

        // Check if the new position is within the screen bounds in the Y direction
        if (screenRect.contains(tempRectY)) {
            spriteRect.y += (int) dy; // Apply movement if within bounds
        } else {
            dy = -dy; // Reverse direction if out of bounds
        }
    }

}
