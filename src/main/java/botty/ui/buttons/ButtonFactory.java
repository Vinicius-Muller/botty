package botty.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ButtonFactory extends StackPane {
  private final Button button;

  public ButtonFactory(String placeholder) {
    this.button = new Button(placeholder);

    getChildren().add(this.button);
  }

  public Button getButton() {
    return this.button;
  }
}