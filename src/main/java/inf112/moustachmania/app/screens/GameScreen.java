package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.model.IModel;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.controller.IController;

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
    public void dispose() {
        view.dispose();
        controller.dispose();
    }


    @Override
    public void render(float deltaTime) {
        view.render(deltaTime);
        controller.update(deltaTime);
        model.update(deltaTime);
        SoundController.getInstance().update();

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
    public void show() {
    }
}
