package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.moustachmania.app.Main;

public class StartScreen implements Screen {
    private final Stage stage;
    private final Main game;

    // Constructor
    public StartScreen(final Main game) {
        this.game = game;
        stage = new Stage();
        Table uiRoot = new Table();
        uiRoot.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        TextButton textButton = new TextButton("New game", game.getSkin());
        textButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //handleNewGameButtonEvent();
            }
        });
        buttonTable.add(textButton).spaceBottom(10).fillX();
        buttonTable.row();
        textButton = new TextButton("perhaps continue game???", game.getSkin());
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

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);
        stage.draw();
        stage.act();
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
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void hide() {}
}
