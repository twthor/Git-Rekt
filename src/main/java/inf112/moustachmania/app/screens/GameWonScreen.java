package inf112.moustachmania.app.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
    private Texture imageTexture;

    public GameWonScreen(MoustacheMania game) {
        this.game = game;
        this.stage = new Stage();
        game.gameWonScreen = this;
        game.setScreen(this);

        Table table = new Table();
        table.setFillParent(true);

        Table buttonTable = new Table();
        buttonTable.padLeft(10.0f);

        //addImage(Constants.)

        // Play next level
        TextButton nextLevelButton = new TextButton("Play next level", game.getSkin());
        nextLevelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                //nextLevelEventHandler();
                nextLevel(true);
            }
        });


        // Sets up "play agin" button and event handling
        TextButton playAgainButton = new TextButton("Play again", game.getSkin());
        playAgainButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float a, float b) {
                //playAgainEventHandler();
                nextLevel(false);
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

        buttonTable.add(nextLevelButton).spaceBottom(10).fillX().padTop(400);
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

    // Need to fix issues with "play again" and what happens when "play next" being on the last level
    public void nextLevel(boolean nextLevel) {
        int currentLevel = game.levelScreen.currentLevel();
        int levelToLoad;

        if (nextLevel) {
            levelToLoad = currentLevel + 1;
        } else {
            levelToLoad = currentLevel;
        }

        Player player = new Player();
        Model model = new Model(game, player);
        IView view = new View(game, model, levelToLoad);
        IController controller = new Controller(game, model);

        game.gameScreen = new GameScreen(game, view, controller, model);
        game.setScreen(game.gameScreen);
        model.setStartPosition();
        dispose();
    }



    /*
    public void nextLevelEventHandler() {
        // Need new instances of these classes to "create" a new game when trying a level again
        Player player = new Player();
        Model model = new Model(game, player);
        IView view = new View(game, model, game.levelScreen.currentLevel() + 1);
        IController controller = new Controller(game, model);

        game.gameScreen = new GameScreen(game, view, controller, model);
        game.setScreen(game.gameScreen);
        model.setStartPosition(); // Sets the player to the start position of the level
        dispose();
    }

    public void playAgainEventHandler() {
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

     */

    public void anotherLevelScreenEventHandler() {
        game.levelScreen = new LevelScreen(game);
        game.setScreen(game.levelScreen);
    }

    public void backToStartScreenEventHandler() {
        game.startScreen = new StartScreen(game);
        game.setScreen(game.startScreen);
        dispose();
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
    public void resize(int i, int i1) {

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
