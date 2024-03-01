package inf112.moustachmania.app.model;

import inf112.moustachmania.app.MoustacheMania;
import com.badlogic.gdx.graphics.Texture;
import inf112.moustachmania.app.screens.GameState;
import inf112.moustachmania.app.controller.ControllableModel;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.view.ViewableModel;
import inf112.moustachmania.app.model.map.MapController;

import java.awt.*;

public class Model implements ViewableModel, ControllableModel {

    // Field variables
    private final Player player;

    private final MoustacheMania game;
    private final MapController mapController;

    public Model(final MoustacheMania game, Player player) {
        this.game = game;
        this.player = player;
        this.mapController = MapController.getInstance();
    }

    public void updateScreenSize(int width, int height) {

    }

    public void updatePosition() {

    }

    @Override
    public void setGameOver() {

    }


    public String getTileMapPath() {
        return mapController.getTileMapPath();
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
    public void update(float delta) {
        
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public GameState getGameState() {
        return game.getGameState();
    }

}
