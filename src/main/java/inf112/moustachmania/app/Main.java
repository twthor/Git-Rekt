package inf112.moustachmania.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import inf112.moustachmania.app.Screens.StartScreen;
import inf112.moustachmania.app.utils.Consts;

public class Main extends Game {

    public StartScreen startScreen;

    private SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("Moustache Mania");
        cfg.setWindowedMode(480, 320);

        new Lwjgl3Application(new Main(), cfg);
    }

    @Override
    public void create() {
        this.setScreen(new StartScreen(this));
        batch = new SpriteBatch();
        font = new BitmapFont();
        skin = new Skin(Gdx.files.internal(Consts.skinPath));
    }

    public Skin getSkin() {
        return this.skin;
    }
}
