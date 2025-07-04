package botty;

import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class ButtonFactoryTest extends ApplicationTest {

    private Button testButton;

    @Override
    public void start(Stage stage) {
        testButton = RoundButtonFactory.createButton("test");
        testButton.setId("testButton");

        StackPane root = new StackPane(testButton);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void shouldRenderButton() {
        // wait to ensure rendering
        sleep(500);

        assertNotNull(testButton, "Button was not initialized");
        assertTrue(testButton.isVisible(), "Button is not visible");

        // Alternatively use lookup
        Button foundButton = lookup("#testButton").queryButton();
        assertNotNull(foundButton, "Button not found via lookup");
    }
}
