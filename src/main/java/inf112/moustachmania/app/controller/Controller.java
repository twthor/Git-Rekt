package inf112.moustachmania.app.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.MoustacheMania;

public class Controller implements IController {
    private final Model model;
    private final MoustacheMania game;

    public Controller(final MoustacheMania game, Model model) {
        this.game = game;
        this.model = model;
    }


    /**
        Handles player input
    */
    public void handleInput() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // TODO: player.setWalkingState(direction left)
            model.getPlayer().movePlayer(-1,0);
        } else {
            //TODO: model.getPlayer().setState(PlayerState.Standing);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            // TODO: player.setWalkingState(direction right)
            model.getPlayer().movePlayer(1,0);
        } else {
            // TODO player.setState(PlayerState.Standing);

        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            model.getPlayer().movePlayer(0,0);
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
