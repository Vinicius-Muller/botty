package botty.botty.ui.label;

import javafx.scene.text.Text;
import botty.botty.enums.Enums;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TextController extends StackPane {
  Text text;

  public TextController(String textContent, String kind, byte size) {
    String styles = Enums.getStyle(kind);

    text = new Text(textContent);
    text.setWrappingWidth(550);
    text.setFont(Font.font("Arial", FontWeight.NORMAL, size));

    getChildren().add(text);
  }
}
