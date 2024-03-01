package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import inf112.moustachmania.app.MoustacheMania;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class HelpScreen implements Screen {

    private final Stage stage;
    private final MoustacheMania game;

    // Constructor
    public HelpScreen(MoustacheMania game) {
        this.stage = new Stage(new ScreenViewport()); // uses viewport, does not scale the stage with window-size however
        this.game = game;


        Table uiRoot = new Table();
        uiRoot.setFillParent(true);
        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        TextButton helpButton = new TextButton("Back to start-screen", game.getSkin());
        helpButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //handleNewGameButtonEvent();
                game.startScreen = new StartScreen(game);
                game.setScreen(game.startScreen);
            }
        });
        buttonTable.add(helpButton).spaceBottom(10).fillX();
        buttonTable.row();

        // Putting buttons on the screens:
        uiRoot.add(buttonTable).expand().fill();
        stage.addActor(uiRoot);

        // Creates a table to contain description of the controls
        Table controlsTable = new Table();
        controlsTable.pad(10);

        //  Creating Labels description for controls
        Label titleLabel = new Label("Game Controls:", game.getSkin());
        Label moveLabel = new Label("Move: Arrow keys/WASD", game.getSkin());
        Label actionLabel = new Label("Action: Spacebar/E", game.getSkin());


        // Add the labels to the controlsTable
        controlsTable.add(titleLabel).padBottom(20).row();
        uiRoot.row();
        controlsTable.add(moveLabel).padBottom(10).row();
        controlsTable.add(actionLabel).row();

        uiRoot.add(controlsTable).expand().top();
        Gdx.input.setInputProcessor(stage);

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
        stage.dispose();
    }
}
