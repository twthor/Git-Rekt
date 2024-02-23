package inf112.moustachmania.app.player;

import java.awt.*;

public class Player implements ViewableCharacter, ControllablePlayer {

    // field variables
    // private final Figure figure;
    private Point position;
    private Point destination;
    // // Tenker mål kan angis ved koordinater.
    // private int[] finishline;
    // Når man befinner seg på de koordinatene, så blir boolean true.
    private boolean goalReached;
    private boolean powerUp;

    public Player() {
        this.position = new Point(0, 0);
        this.destination = new Point(0, 0);
        this.goalReached = false;
        this.powerUp = false;
        // this.finishline = new int[]{20, 20}; // e.g.
    }

    @Override
    public Point getPosition() {
        return new Point(position.getLocation());
    }

    @Override
    public void setPosition(Point pos) {
        if (pos != position) {
            return;
        }
        this.position.setLocation(pos.getLocation()); // x & y
    }

    @Override
    public void setDestination(Point pos) {
        this.destination.setLocation(pos.getLocation()); // x & y
    }

    @Override
    public boolean goalReached() {
        return this.goalReached;
    }

    @Override
    public boolean havePowerUp() {
        return this.powerUp;
    }

    @Override
    public void updatePowerUpStatus(boolean status) {
        this.powerUp = status;
    }


    @Override
    public void getCharacter() {
    }

    public void setGoalReached() {
        this.goalReached = true;
    }

    /**
     * Moves the player and updates the new position.
     */
    public void movePlayer() {
        // X direction
        if (destination.getX() > position.getX()) {
            position.x += 1;
        } else if (destination.getX() < position.getX()) {
            position.x -= 1;
        }
        // Y direction
        if (destination.getY() > position.getY()) {
            position.y += 1;
        } else if (destination.getY() < position.getY()) {
            position.y -= 1;
        }
    }

    public boolean isMoving() {
        return (!destination.equals(position));
    }
}
