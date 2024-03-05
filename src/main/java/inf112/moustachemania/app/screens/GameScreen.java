package inf112.moustachemania.app.screens;

import com.badlogic.gdx.Screen;
import inf112.moustachemania.app.MoustacheMania;
import inf112.moustachemania.app.model.IModel;
import inf112.moustachemania.app.view.IView;
import inf112.moustachemania.app.controller.IController;

public class GameScreen implements Screen {
    private final MoustacheMania game;
    private final IView view;
    private final IController controller;
    
    private final IModel model;

    public GameScreen(final MoustacheMania game, IView view, IController controller, IModel model) {
        this.game = game;
        this.view = view;
        this.controller = controller;
        this.model = model;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {
        view.render(deltaTime);
        controller.update(deltaTime);
        model.update(deltaTime);
        game.getGameState();

        controller.handleInput();
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
