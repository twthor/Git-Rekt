package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.controller.IController;

public class GameScreen implements Screen {
    //private final Stage stage;
    private final MoustacheMania game;
    private final IView view;
    private final IController controller;

    public GameScreen(final MoustacheMania game, IView view, IController controller) {
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
