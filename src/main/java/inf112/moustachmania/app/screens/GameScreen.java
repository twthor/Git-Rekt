package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.view.ViewableModel;
import inf112.moustachmania.app.controller.ControllableModel;

public class GameScreen implements Screen {
    //private final Stage stage;
    private final MoustacheMania game;
    private final ViewableModel view;
    private final ControllableModel controller;

    // Constructor
    public GameScreen(final MoustacheMania game, ViewableModel view, ControllableModel controller) {
        this.game = game;
        this.view = view;
        this.controller = controller;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        view.render(v);
        controller.update(v);
        game.getGameState();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        view.dispose();
        controller.dispose();

    }
}
