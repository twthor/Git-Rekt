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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.graphics.Texture;
import java.util.ArrayList;

public class HelpScreen implements Screen {

    private ArrayList<Texture> texturesToDispose; // List to handle image textures to be disposed
    private final Stage stage;
    private final MoustacheMania game;


    public HelpScreen(MoustacheMania game) {
        this.stage = new Stage(new ScreenViewport()); // uses viewport, does not scale the stage with window-size however
        this.game = game;
        this.texturesToDispose = new ArrayList<>();

        addBackgroundImage("assets/testPicture.png");

        setupUiTable();

        show();
    }


    private void setupUiTable() {
        Table uiRoot = new Table();
        uiRoot.setFillParent(true);
        stage.addActor(uiRoot);

        setupControllerDescription(uiRoot);
        uiRoot.row().padTop(20);
        setupBackTostartScreenButton(uiRoot);

    }


    /**
     * Adds a table to the given uiRoot, containing a description of the game controls
     * @param uiRoot The root table to add the controlsTable to
     */
    // set up description of the controls and lables to controlsTable
    private void setupControllerDescription(Table uiRoot) {
        Table controlsTable = new Table();
        controlsTable.pad(10);

        // Creating Labels description for controls
        Label titleLabel = new Label("Game Controls:", game.getSkin());
        Label moveLabel = new Label("Move: Arrow keys  <-  -> ", game.getSkin());
        Label jumpLabel = new Label("Jump: Spacebar  ===== ", game.getSkin());
        Label pauseGameLabel = new Label("Pause game:  esc ", game.getSkin());

        // Scaling the size of the labels
        titleLabel.setFontScale(2.5f);
        moveLabel.setFontScale(1.5f);
        jumpLabel.setFontScale(1.5f);
        pauseGameLabel.setFontScale(1.5f);

        // Add the labels to the controlsTable
        controlsTable.add(titleLabel).padBottom(20).padTop(10).center().row();
        controlsTable.add(moveLabel).padBottom(10).left().row();
        controlsTable.add(jumpLabel).padBottom(10).left().row();
        controlsTable.add(pauseGameLabel).padBottom(10).left().row();

        uiRoot.add(controlsTable).expand().fill();
    }


    /**
     * Adds a background image to the stage
     * @param imagePath the path to the image to be added
     */
    private void addBackgroundImage(String imagePath) {
        Texture imageTexture = new Texture(Gdx.files.internal(imagePath));
        Image image = new Image(imageTexture);
        image.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(image);

        texturesToDispose.add(imageTexture);
    }


    /**
     * Adds a back to start-screen button to the given uiRoot
     * @param uiRoot The root table to add the button to
     */
    private void setupBackTostartScreenButton(Table uiRoot) {
        TextButton helpButton = new TextButton("Back to start-screen", game.getSkin());
        helpButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.startScreen = new StartScreen(game);
                game.setScreen(game.startScreen);
            }
        });
        uiRoot.add(helpButton).spaceBottom(10).fillX();
    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
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
        for (Texture texture : texturesToDispose) {
            texture.dispose();
        }
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
