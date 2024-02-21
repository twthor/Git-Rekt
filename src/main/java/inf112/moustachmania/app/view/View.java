package inf112.moustachmania.app.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import inf112.moustachmania.app.model.Model;

import javax.swing.*;

public class View extends JComponent {
    private final SpriteBatch batch;
    private final BitmapFont font;
    private final Texture spriteImage;

    public View(SpriteBatch batch, BitmapFont font, Texture spriteImage) {
        this.batch = batch;
        this.font = font;
        this.spriteImage = spriteImage;
    }

    public void render(Model model) {
        ScreenUtils.clear(Color.WHITE);
        batch.begin();
        font.draw(batch, "Hello, World!", 200, 200);
        batch.draw(spriteImage, model.spriteRect.x, model.spriteRect.y, model.spriteRect.width, model.spriteRect.height);
        batch.end();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        spriteImage.dispose();
    }
}

