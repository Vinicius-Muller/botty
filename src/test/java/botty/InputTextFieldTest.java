package botty;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import botty.ui.TextField.TextInputField;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class InputTextFieldTest extends ApplicationTest {

    private TextInputField textField;

    @Override
    public void start(Stage stage) {
        textField = new TextInputField();
        textField.setId("textField");

        StackPane root = new StackPane(textField);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void shouldRenderTextInput() {
        sleep(500);

        assertNotNull(textField, "Text Field was not initialized");
        assertTrue(textField.isVisible(), "Text Field is not visible");

        TextInputField found = lookup("textField").query();
        assertNotNull(found, "Text area not found via lookup");
    }
}
