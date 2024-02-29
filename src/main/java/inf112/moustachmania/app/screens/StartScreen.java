package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.moustachmania.app.MoustacheMania;

public class StartScreen implements Screen {
    private final Stage stage;
    private final MoustacheMania game;

    // Constructor
    public StartScreen(final MoustacheMania game) {
        this.game = game;
        stage = new Stage();

        Table uiRoot = new Table();
        uiRoot.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        //TextButton.TextButtonStyle textButtonStyle = game.getSkin().get("default", TextButton.TextButtonStyle.class);

        TextButton textButton = new TextButton("New game", game.getSkin());        //textButton.getLabel().setColor(1, 1, 1, 1);
        textButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                handleNewGameButtonEvent();
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

    private void handleNewGameButtonEvent() {
        //Player player = new Player(30, 30);
        //IWorldModel model = new WorldModel(game, player);
        //IWorldView view = new WorldView(game, model);
        //IWorldController controller = new WorldController(game, model);

        //game.worldScreen = new WorldScreen(game, view, controller);
        //game.setScreen(game.worldScreen);

        dispose();
    }
    
    private void handleExitGameButtonEvent() {
        Gdx.app.exit();
    };

    private void handleControlsHelpGameButtonEvent() {
        game.helpScreen = new HelpScreen(game);
        game.setScreen(game.helpScreen);

        dispose();


    }



}
