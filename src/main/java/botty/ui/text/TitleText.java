package botty.ui.text;

import botty.enums.Placeholders;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TitleText {
  private static Text text;

  public static StackPane getTitleComponent() {
    text = new Text(Placeholders.TITLE.getText());
    text.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
    text.setWrappingWidth(500);
    text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(text);

    return stackPane;
  }
}
