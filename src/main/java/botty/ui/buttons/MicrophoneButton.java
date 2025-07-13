package botty.ui.buttons;

import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import javafx.scene.paint.Color;


public class MicrophoneButton extends StackPane {
  private final Button microphoneButton;

  public MicrophoneButton() {
    this.microphoneButton = RoundButtonFactory.createButton("\uD83C\uDFA4");
    FontIcon micIcon = new FontIcon(MaterialDesign.MDI_MICROPHONE);
    micIcon.setIconSize(24);
    micIcon.setIconColor(Color.WHITE);
    this.microphoneButton.setGraphic(micIcon);
    getChildren().add(this.microphoneButton);
  }

  public Button getMicrophoneButton() {
    return this.microphoneButton;
  }
}
