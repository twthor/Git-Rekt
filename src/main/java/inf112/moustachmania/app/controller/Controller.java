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

public class Controller implements Controllable, ApplicationListener {
    private Model model;
    private View view;
    private Sound bellSound;

    @Override
    public void create() {
        SpriteBatch batch = new SpriteBatch();
        BitmapFont font = new BitmapFont();
        font.setColor(Color.RED);
        Texture spriteImage = new Texture(Gdx.files.internal("obligator.png"));
        bellSound = Gdx.audio.newSound(Gdx.files.internal("blipp.ogg"));
        Gdx.graphics.setForegroundFPS(60);

        model = new Model(spriteImage);
        view = new View(batch, font, spriteImage);
    }

    @Override
    public void render() {
        model.updatePosition();
        view.render(model);

        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.justTouched()) {
            bellSound.play();
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
    }

    @Override
    public void resize(int width, int height) {
        model.updateScreenSize(width, height);
    }

    @Override
    public void dispose() {
        view.dispose();
        bellSound.dispose();
        // Huske å dispose nye ting.
    }

    // Implementere pauses og resume
    @Override
    public void pause() {}

    @Override
    public void resume() {}
}
