package inf112.moustachmania.app.controller;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.view.View;
import inf112.moustachmania.app.MoustacheMania;

public class Controller implements ControllableModel {
    private final Model model;
    private final MoustacheMania game;

    public Controller(final MoustacheMania game, Model model) {
        this.game = game;
        this.model = model;
    }


    /**
        Handles player input
    */
    private void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    public void resize(int width, int height) {
        model.updateScreenSize(width, height);
    }

    // Implementere pauses og resume
    public void pause() {}

    public void resume() {}

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void setGameOver() {

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
}
