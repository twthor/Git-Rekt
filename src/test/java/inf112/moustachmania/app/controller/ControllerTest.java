package inf112.moustachmania.app.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import inf112.moustachmania.app.MoustacheMania;
import inf112.moustachmania.app.model.Model;
import inf112.moustachmania.app.model.entities.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {
    @Test
    public void updateModel() {
        // Arrange
        MoustacheMania game = new MoustacheMania();
        Model model = new Model(game, new Player());
        IController controller = new Controller(game, model);

        Gdx.input = mock(Input.class); // mock the input such that the right key is always pressed
        when(Gdx.input.isKeyPressed(Input.Keys.RIGHT)).thenReturn(true);

        // Act
        controller.update(10);

        // Assert
        assertNotEquals(new Vector2(0, 0), model.getPlayer().getPosition());
    }


}
