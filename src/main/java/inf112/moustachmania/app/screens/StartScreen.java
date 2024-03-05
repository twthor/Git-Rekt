package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.audio.Music;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.controller.SoundController;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.view.IView;
import inf112.moustachmania.app.view.View;
import inf112.moustachmania.app.player.Player;
import inf112.moustachmania.app.controller.Controller;
import inf112.moustachmania.app.controller.IController;

public class StartScreen implements Screen {
    private final Stage stage;
    private final MoustacheMania game;
    private SoundController soundController;


    // TODO: split functionality from the constructor into different helper methods
    // Constructor
    public StartScreen(final MoustacheMania game) {
        this.game = game;
        stage = new Stage();

        Table uiRoot = new Table();
        uiRoot.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        //TextButton.TextButtonStyle textButtonStyle = game.getSkin().get("default", TextButton.TextButtonStyle.class);

        // Game title
        Texture titleTexture = new Texture("assets/moustachemania.png");
        Image titleImage = new Image(titleTexture);
        buttonTable.add(titleImage).padBottom(20).row(); // row() puts the image on its own row in buttonTable.


        TextButton textButton = new TextButton("New game", game.getSkin());        //textButton.getLabel().setColor(1, 1, 1, 1);
        textButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleNewGameButtonEvent();
            }
        });
        buttonTable.add(textButton).spaceBottom(10).fillX();

        buttonTable.row();
        textButton = new TextButton("Continue game?", game.getSkin());
        textButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //handleNewGameButtonEvent();

                //mulig flytte dette opp eller til en egen metode
                game.startScreen = new StartScreen(game);
                game.setScreen(game.startScreen);
                //dispose();
            }
        });
        buttonTable.add(textButton).spaceBottom(10).fillX();

        // Controller help button
        buttonTable.row();
        textButton = new TextButton("Controls", game.getSkin());
        textButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                handleControlsHelpGameButtonEvent();
            }});
        buttonTable.add(textButton).spaceBottom(10).fillX();

        // Quit game button
        buttonTable.row();
        textButton = new TextButton("Exit game", game.getSkin());
        textButton.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y) {
                handleExitGameButtonEvent();
        }});
        buttonTable.add(textButton).spaceBottom(10).fillX();

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


    // ButtonEvent for when starting the game
    private void handleNewGameButtonEvent() {
        Player player = new Player();
        Model model = new Model(game, player);
        IView view = new View(game, model);
        IController controller = new Controller(game, model);

        game.gameScreen = new GameScreen(game, view, controller, model);
        game.setScreen(game.gameScreen);

        // Sets the player field variable in the sound controller, so we can play sounds based on player events
        SoundController.getInstance().setPlayer(player);

        dispose();
    }

    private void handleControlsHelpGameButtonEvent() {
        game.helpScreen = new HelpScreen(game);
        game.setScreen(game.helpScreen);

        dispose();
    }

    // Closes the game window
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
