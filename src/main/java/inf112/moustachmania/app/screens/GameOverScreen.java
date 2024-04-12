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
import inf112.moustachmania.app.model.entities.Player;
import inf112.moustachmania.app.utils.Constants;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.view.View;

public class GameOverScreen implements Screen {
    private final Stage stage;
    private Texture imageTexture;
    MoustacheMania game;


    public GameOverScreen(MoustacheMania game) {
        this.stage = new Stage();
        this.game = game;
        game.gameOverScreen = this;
        game.setScreen(this);

        addBackgroundImage(Constants.gameOverPicture);

        Table table = new Table();
        table.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        // Sets up "try again" button and event handling
        TextButton tryAgainButton = new TextButton("Try again", game.getSkin());
        tryAgainButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                tryAgainEventHandler();
            }
        });

        //sets up "play another level" button and event handling
        TextButton playOtherLevelButton = new TextButton("Play another level", game.getSkin());
        playOtherLevelButton.addListener(new ClickListener() {
             @Override
             public void clicked(InputEvent event, float a, float b) {
                 playOtherLevelEventHandler();
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

        buttonTable.add(tryAgainButton).spaceBottom(10).fillX().padTop(400);
        buttonTable.row();

        buttonTable.add(playOtherLevelButton).spaceBottom(10).fillX();
        buttonTable.row();

        buttonTable.add(exitGameButton).spaceBottom(10).fillX();
        buttonTable.row();

        table.add(buttonTable).expand().fillX();
        stage.addActor(table);
        show();
    }


    /**
     * tryAgainEventHandler readies a new game after failing a current game. Initiates new components
     * of the game and sets up the structure for the game to load and start over.
     * After the game are initiated and set up properly, dispose() is called to avoid memory leakage.
     */
    private void tryAgainEventHandler() {
        // Need new instances of these classes to "create" a new game when trying a level again
        Player player = new Player();
        Model model = new Model(game, player);
        IView view = new View(game, model, game.levelScreen.currentLevel());
        IController controller = new Controller(game, model);

        game.gameScreen = new GameScreen(game, view, controller, model);
        game.setScreen(game.gameScreen);
        model.setStartPosition(); // Sets the player to the start position of the level
        dispose();
    }


    /**
     * playOtherLevelEventHandler handles the case where the player wants to play another
     * level than the next or current one again after completion. Creates a new level-screen
     * and puts level-screen active. Calls dispose() to avoid memory leakage after handling the case.
     */
    private void playOtherLevelEventHandler() {
        game.levelScreen = new LevelScreen(game);
        game.setScreen(game.levelScreen);
        dispose();
    }


    /**
     * backToStartScreenEventHandler creates a new instance of start-game and then set the
     * current game to start-screen. Calls dispose() to avoid memory leakage after handling the case.
     */
    private void backToStartScreenEventHandler() {
        game.startScreen = new StartScreen(game);
        game.setScreen(game.startScreen);
        dispose();
    }


    /**
     * addBackgroundImage Adds and format a background image when the game is over.
     * @param imagePath takes in the local constant path of the image.
     */
    private void addBackgroundImage(String imagePath) {
        imageTexture = new Texture(Gdx.files.internal(imagePath));
        Image backgroundImage = new Image(imageTexture);
        backgroundImage.setColor(1,1,1,0.4f);
        backgroundImage.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(backgroundImage); // Adds background image to the stage
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
