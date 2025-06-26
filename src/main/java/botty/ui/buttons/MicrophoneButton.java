package botty.ui.buttons;

import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MicrophoneButton extends StackPane {
  private final Button microphoneButton;

  public MicrophoneButton() {
    microphoneButton = RoundButtonFactory.createButton("\uD83C\uDFA4");
    getChildren().add(microphoneButton);
  }

  public Button getMicrophoneButton() {
    return microphoneButton;
  }
}
