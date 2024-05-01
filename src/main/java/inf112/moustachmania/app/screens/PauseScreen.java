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
import inf112.moustachmania.app.utils.Constants;

public class PauseScreen implements Screen {

    private final Stage stage;
    MoustacheMania game;


    public PauseScreen(MoustacheMania game) {
        this.stage = new Stage();
        this.game = game;

        game.pauseScreen = this;
        game.setScreen(this);

        addBackgroundImage(Constants.backgroundPicture);

        Table table = new Table();
        Table buttonTable = new Table();

        table.setFillParent(true);
        buttonTable.padLeft(10.0f);

        // Button to continue/resume game
        TextButton resumeGameButton = new TextButton("Resume game", game.getSkin());
        resumeGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                handleResumeGameButtonEvent();
            }
        });
        buttonTable.add(resumeGameButton).spaceBottom(10).fillX();
        buttonTable.row();


        // Button to exit game
        TextButton exitGameButton = new TextButton("Quit level", game.getSkin());
        exitGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                handleBackToStartScreenButtonEvent();
            }
        });
        buttonTable.add(exitGameButton).spaceBottom(10).fillX();
        buttonTable.row();

        table.add(buttonTable).expand().fill(); // Add buttons to the main table and formats and fill up available space in the table
        stage.addActor(table); // adds the main table to the stage
        show();

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(v);
        stage.draw();
    }


    @Override
    public void resize(int width, int height)  {
        stage.getViewport().update(width, height, true);
    }


    @Override
    public void dispose() {
        stage.dispose();

    }


    /**
     * backToStartScreenEventHandler creates a new instance of start-game and then set the
     * current game to start-screen. Calls dispose() to avoid memory leakage after handling the case.
     */
    private void handleBackToStartScreenButtonEvent() {
        game.startScreen = new StartScreen(game);
        game.setScreen(game.startScreen);
        dispose();
    }


    /**
     * handleResumeGameButtonEvent resumes the game after being paused. Puts the game back to
     * the previous current state, then calls dispose afterwards getting rid of textures or similar
     * which can lead to memory leakage.
     */
    private void handleResumeGameButtonEvent() {
        game.setScreen(game.gameScreen);
        dispose();
    }


    /**
     * addBackgroundImage Adds and format a background image when the game is paused.
     * @param imagePath takes in the local constant path of the image.
     */
    private void addBackgroundImage(String imagePath) {
        Texture imageTexture = new Texture(Gdx.files.internal(imagePath));
        Image pausedBackgroundImage = new Image(imageTexture);
        pausedBackgroundImage.setColor(1,1,1,0.4f);
        pausedBackgroundImage.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(pausedBackgroundImage); // Adds background image to the stage
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
