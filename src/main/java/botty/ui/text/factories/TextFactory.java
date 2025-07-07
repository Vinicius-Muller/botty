package botty.ui.text.factories;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextFactory {
  private final Text text;
  private final StackPane stackPane = new StackPane();

  public TextFactory(String value, Font fontConfig) {
    text = new Text(value);
    text.setFont(fontConfig);
    text.setWrappingWidth(500);
    text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

    stackPane.getChildren().add(text);
  }

  public StackPane getTitleStackPane() {
    return stackPane;
  }

  public Text getText() {
    return text;
  }
}
