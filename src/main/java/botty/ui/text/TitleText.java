package botty.ui.text;

import botty.enums.Placeholders;
import botty.ui.text.factories.TextFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleText extends TextFactory {
  public TitleText() {
    super(Placeholders.TITLE.getText(), Font.font("Arial", FontWeight.NORMAL, 15));
  }
}
