package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.controller.Controller;
import inf112.moustachmania.app.controller.IController;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.model.entities.Player;
import inf112.moustachmania.app.utils.Constants;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.view.View;

public class LevelScreen implements Screen {

    private final Stage stage;
    private final MoustacheMania game;
    private int currentLevelNumber = 0; // "placeholder" bane-indeks
    private Texture imageTexture;


    public LevelScreen(final MoustacheMania game) {
        this.game = game;
        stage = new Stage();

        Table uiRoot = new Table();
        uiRoot.setFillParent(true);

        // adds backgroundImage
        addImage(Constants.levelScreenBackground);

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
        }

        // sets up "exit game" button and event handling
        TextButton exitGameButton = new TextButton("Back to main menu", game.getSkin());
        exitGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                backToStartScreenEventHandler();
            }
        });

        uiRoot.add(exitGameButton).spaceBottom(10).fillX().row();
        stage.addActor(uiRoot);
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
            model.setStartPosition(); // Sets the player to the start position of the level
        }
        else {
            Gdx.app.log("LevelScreen", "Invalid level number: " + levelNumber);
        }
    }


    /**
     * Adds a back to start-screen button to the given uiRoot
     */
    public void backToStartScreenEventHandler() {
        game.startScreen = new StartScreen(game);
        game.setScreen(game.startScreen);
        dispose();
    }


    /**
     * adds an internal image to the stage
     */
    private void addImage(String imagePath) {
        imageTexture = new Texture(Gdx.files.internal(imagePath));
        Image image = new Image(imageTexture);
        image.setColor(1,1,1,0.5f);
        image.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(image);
    }


    /**
     * currentLevel method return the current level the player is playing.
    */
    public int currentLevel() {
        return currentLevelNumber;
    }


    /**
      * setCurrentLevel method updates the current level of the game.
     */
    public void setCurrentLevel(int level) {
        this.currentLevelNumber = level;
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
        if (imageTexture != null) {
            imageTexture.dispose();
        }
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
}
