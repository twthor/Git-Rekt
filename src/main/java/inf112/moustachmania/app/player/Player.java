package inf112.moustachmania.app.player;

public class Player implements ViewablePlayer, ControllablePlayer {

    // field variables
    // private final Figure figure;
    private int[] position;
    private int[] destination;
    // // Tenker mål kan angis ved koordinater.
    // private int[] finishline;
    // Når man befinner seg på de koordinatene, så blir boolean true.
    private boolean goalReached;
    private boolean powerUp;

    public Player() {
        this.position = new int[]{0, 0};
        this.destination = new int[]{0, 0};
        this.goalReached = false;
        this.powerUp = false;
        // this.finishline = new int[]{20, 20}; // e.g.
    }

    @Override
    public int[] getPosition() {
        return position;
    }

    @Override
    public void setPosition(int[] pos) {
        if (pos != position) {
            return;
        }
        this.position[0] = pos[0]; // x
        this.position[1] = pos[1]; // y

    }

    @Override
    public void setDestination(int[] pos) {
        this.destination[0] = pos[0];
        this.destination[1] = pos[1];
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
    public void getPlayer() {
    }

    public void setGoalReached() {
        this.goalReached = true;
    }

    /**
     * Moves the player and updates the new position.
     */
    public void movePlayer() {
        // X direction
        if (destination[0] > position[0]) {
            position[0] += 1;
        } else if (destination[0] < position[0]) {
            position[0] -= 1;
        }
        // Y direction
        if (destination[1] > position[1]) {
            position[1] += 1;
        } else if (destination[1] < position[1]) {
            position[1] -= 1;
        }
    }

    public boolean isMoving() {
        return (destination[0] != position[0]) && (destination[1] != position[1]);
    }
}
