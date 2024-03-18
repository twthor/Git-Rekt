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
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.utils.Constants;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.view.View;

public class GameWonScreen implements Screen {

    MoustacheMania game;
    Stage stage;
    private Texture imageTexture; // will implement soon
    int levelCount;
    public GameWonScreen(MoustacheMania game) {
        this.game = game;
        this.stage = new Stage();
        game.gameWonScreen = this;
        game.setScreen(this);
        levelCount = game.levelScreen.currentLevel();

        Table table = new Table();
        table.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        addImage(Constants.gameWonScreenBackground);

        // Play next level
        TextButton nextLevelButton = new TextButton("Play next level", game.getSkin());
        nextLevelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                nextLevelEventHandler();
            }
        });


        // Sets up "play agin" button and event handling
        TextButton playAgainButton = new TextButton("Play again", game.getSkin());
        playAgainButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                playAgainEventHandler();
            }
        });

        TextButton levelsButton = new TextButton("play another level", game.getSkin());
        levelsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                anotherLevelScreenEventHandler();
            }
        });

        // sets up "exit game" button and event handling
        TextButton exitGameButton = new TextButton("Back to main menu", game.getSkin());
        exitGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                backToStartScreenEventHandler();
            }
        });

        buttonTable.add(nextLevelButton).spaceBottom(10).fillX().padTop(620);
        buttonTable.row();

        buttonTable.add(playAgainButton).spaceBottom(10).fillX();
        buttonTable.row();

        buttonTable.add(levelsButton).spaceBottom(10).fillX();
        buttonTable.row();

        buttonTable.add(exitGameButton).spaceBottom(10).fillX();
        buttonTable.row();

        table.add(buttonTable).expand().fillX();
        stage.addActor(table);
        show();
    }

    public void nextLevelEventHandler() {
        int nextLevelNumber = game.levelScreen.currentLevel() + 1;
        // Checks if the next level exists.
        if (nextLevelNumber >= Constants.mapPaths.length) {
            // Redirects back to the levelScreen when playing next after completing the last level.
            game.levelScreen = new LevelScreen(game);
            game.setScreen(game.levelScreen);
        } else {
            // Loads the next level.
            loadLevel(nextLevelNumber);
        }
    }

    public void playAgainEventHandler() {
        int currentLevelNumber = game.levelScreen.currentLevel();
        loadLevel(currentLevelNumber);
    }

    private void loadLevel(int levelIndex) {
        // Creates new components to make up the newly loaded level.
        Player player = new Player();
        Model model = new Model(game, player);
        IView view = new View(game, model, levelIndex);
        IController controller = new Controller(game, model);

        game.gameScreen = new GameScreen(game, view, controller, model);
        game.setScreen(game.gameScreen);
        game.levelScreen.setCurrentLevel(levelIndex);
        model.setEndPosition(); // Ensures the end-position is reset when a level is loaded such that the game registeres when the playrt has reached the goal.
        dispose();
    }

    public void anotherLevelScreenEventHandler() {
        game.levelScreen = new LevelScreen(game);
        game.setScreen(game.levelScreen);
        dispose();
    }

    public void backToStartScreenEventHandler() {
        game.startScreen = new StartScreen(game);
        game.setScreen(game.startScreen);
        dispose();
    }

    private void addImage(String imagePath) {
        imageTexture = new Texture(Gdx.files.internal(imagePath));
        Image image = new Image(imageTexture);
        image.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(image);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0,0,0,1);
        stage.act(v);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        if (imageTexture != null) {
            imageTexture.dispose();
        }
        stage.dispose();
    }
}
