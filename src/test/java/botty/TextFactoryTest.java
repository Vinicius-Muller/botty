package botty;

import botty.ui.text.factories.TextFactory;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.testfx.framework.junit5.ApplicationTest;

public class TextFactoryTest extends ApplicationTest {
    private TextFactory text;

    @Override
    public void start(Stage stage) {
        text = new TextFactory("test", Font.font("Arial", FontWeight.NORMAL, 15));
        text.getText().setId("text");

        StackPane root = new StackPane(text.getText());
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void shouldRenderText() {
        // wait to ensure rendering
        sleep(500);

        assertNotNull(text, "Text was not initialized");
        assertTrue(text.getText().isVisible(), "Text is not visible");

        // Alternatively use lookup
        //Button foundText = lookup("#text").queryText();
        //assertNotNull(foundText, "text not found via lookup");
    }
}
