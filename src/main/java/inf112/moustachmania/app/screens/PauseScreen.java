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
import inf112.moustachmania.app.model.IModel;
import inf112.moustachmania.app.utils.Constants;

public class PauseScreen implements Screen {

    private final Stage stage;
    MoustacheMania game;
    IModel model;

    public PauseScreen(MoustacheMania game, IModel model) {
        this.stage = new Stage();
        this.model = model;
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
        //buttonTable.add(resumeGameButton); ???
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
        //buttonTable.add(exitGameButton);
        buttonTable.row();

        table.add(buttonTable).expand().fill(); // Add buttons to the main table and formats and fill up available space in the table
        stage.addActor(table); // adds the main table to the stage
        show();

    }

    // Readies current stage for user input and interaction I think???
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    /*
    Updates the screen.
     */
    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(v);
        stage.draw();
    }

    /*
    Ensures that resume and exit button still work when resizing the screen.
     */
    @Override
    public void resize(int width, int height)  {
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

    }

    private void handleBackToStartScreenButtonEvent() {
        game.startScreen = new StartScreen(game);
        game.setScreen(game.startScreen);
        dispose();
    }

    private void handleResumeGameButtonEvent() {
        game.setScreen(game.gameScreen);
        dispose();
    }

    /*
    Adds and format background image to the stage
     */
    private void addBackgroundImage(String imagePath) {
        Texture imageTexture = new Texture(Gdx.files.internal(imagePath));
        Image pausedBackgroundImage = new Image(imageTexture);
        pausedBackgroundImage.setColor(1,1,1,0.4f);
        pausedBackgroundImage.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(pausedBackgroundImage); // Adds background image to the stage
    }

}
