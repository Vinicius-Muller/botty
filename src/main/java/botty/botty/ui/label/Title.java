package botty.botty.ui.label;

import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Title extends StackPane {
  Text text;

  public Title() {
    text = new Text(10, 90, "Type something:");
    text.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
    StackPane.setMargin(text, new javafx.geometry.Insets(-70, 0, 0, 0));
    getChildren().add(text);
  }
}
