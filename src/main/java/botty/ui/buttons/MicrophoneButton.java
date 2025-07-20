package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
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

    this.microphoneButton.setOnMouseClicked(event -> {
      //need to create the recording actinos for the mic button
      Text newText = new Text("test");
      HBox container = new HBox(newText);
      container.setAlignment(Pos.CENTER);
      TextInputField.getTextAreaContainer().getChildren().add(0, container);
    });

    getChildren().add(this.microphoneButton);
  }

  public Button getMicrophoneButton() {
    return this.microphoneButton;
  }
}
