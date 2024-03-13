package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.controller.Controller;
import inf112.moustachmania.app.controller.IController;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.utils.Constants;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.view.View;

public class LevelScreen implements Screen {

    private final Stage stage;
    private final MoustacheMania game;
    private int currentLevelNumber = -1; // "placeholder" bane-indeks


    public LevelScreen(final MoustacheMania game) {
        this.game = game;
        stage = new Stage();

        Table uiRoot = new Table();
        uiRoot.setFillParent(true);

        //add buttons for level selection
        for (int levelNumber = 0; levelNumber < Constants.mapPaths.length; levelNumber++) {
            final int currentLevel = levelNumber + 1;// adjust level number as per the array index
            TextButton levelButton = new TextButton("Level " + currentLevel, game.getSkin());
            int finalLevelNumber = levelNumber;
            levelButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    handleLevelButtonEvent(finalLevelNumber);
                }
            });
            uiRoot.add(levelButton).spaceBottom(10).fillX().row();
            stage.addActor(uiRoot);
        }
    }


    /**
     * Handles the event when a level button is clicked
     * @param levelNumber The level number of the button clicked
     */
    private void handleLevelButtonEvent(int levelNumber) {
        currentLevelNumber = levelNumber; // Holder oversikt over hvilken bane som er "aktiv"
        Player player = new Player();
        Model model = new Model(game, player);
        IView view = new View(game, model, levelNumber);
        IController controller = new Controller(game, model);

        if (levelNumber >= 0 && levelNumber < Constants.mapPaths.length) { // byttet fra <= til <
            game.gameScreen = new GameScreen(game, view, controller, model);
            game.setScreen(game.gameScreen);
            SoundController.getInstance().setPlayer(player);
            model.setStartPosition();
        }
        else {
            Gdx.app.log("LevelScreen", "Invalid level number: " + levelNumber);
        }
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    @Override
    public void dispose() {
        stage.dispose();
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

    /*
    currentLevel method return the current level the player is playing.
     */
    public int currentLevel() {
        return currentLevelNumber;
    }
}
