package inf112.moustachmania.app.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.screens.PauseScreen;

public class Controller implements IController {

    private final Model model;
    private final MoustacheMania game;


    public Controller(final MoustacheMania game, Model model) {
        this.game = game;
        this.model = model;
    }

    /**
     * Handles player input
     */
    public void handleInput() {
        Player player = model.getPlayer();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.setScreen(new PauseScreen(game, model));
            //Gdx.app.exit();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            // TODO: player.setWalkingState(direction left)
            player.movePlayer(-1);
            if (player.grounded) player.state = Player.State.Walking;
            player.facesRight = false;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.movePlayer(1);
            // TODO: player.setWalkingState(direction right)
            if (player.grounded) player.state = Player.State.Walking;
            player.facesRight = true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            player.jumpPlayer();
            if (!player.grounded) player.state = Player.State.Jumping;
        }
    }

    @Override
    public void update(float delta) {
    }
    @Override
    public void dispose() {
    }
}
