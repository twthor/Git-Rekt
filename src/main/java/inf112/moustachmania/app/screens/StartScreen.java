package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
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

public class StartScreen implements Screen {

    private final Stage stage;
    private final MoustacheMania game;


    public StartScreen(final MoustacheMania game) {
        this.game = game;
        stage = new Stage();

        Table uiRoot = new Table();
        uiRoot.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        // Game title
        Texture titleTexture = new Texture(Constants.logoPicture);
        Image titleImage = new Image(titleTexture);
        buttonTable.add(titleImage).padBottom(20).row(); // row() puts the image on its own row in buttonTable.

        TextButton textButton = new TextButton("New game", game.getSkin());
        textButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleNewGameButtonEvent();
            }
        });
        buttonTable.add(textButton).spaceBottom(12).fillX().row();

        // Controller help button
        buttonTable.row();
        textButton = new TextButton("Controls", game.getSkin());
        textButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                handleControlsHelpGameButtonEvent();
            }});
        buttonTable.add(textButton).spaceBottom(12).fillX();

        // Quit game button
        buttonTable.row();
        textButton = new TextButton("Exit game", game.getSkin());
        textButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                handleExitGameButtonEvent();
        }});
        buttonTable.add(textButton).spaceBottom(12).fillX();

        // Putting buttons on the screens:
        uiRoot.add(buttonTable).expand().fill();
        stage.addActor(uiRoot);
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        stage.act(delta);
        stage.draw();
    }


    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    /**
     * Handles the event when the new game button is clicked. Creates a new level-screen and
     * sets the current game to that. Disposes the previous stage.
     */
    private void handleNewGameButtonEvent() {
        game.levelScreen = new LevelScreen(game);
        game.setScreen(game.levelScreen);
        dispose();
    }


    /**
     * Handles the event when the controls help button is clicked. Creates a new help-screen and
     * sets the current state of the game to that. Disposes the previous stage.
     */
    private void handleControlsHelpGameButtonEvent() {
        game.helpScreen = new HelpScreen(game);
        game.setScreen(game.helpScreen);
        dispose();
    }


    /**
     * Closes the game window.
     */
    private void handleExitGameButtonEvent() {
        Gdx.app.exit();
    }


    @Override
    public void dispose() {
        stage.dispose();
    }



    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
}
