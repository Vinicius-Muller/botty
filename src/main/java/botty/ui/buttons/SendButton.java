package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class SendButton extends StackPane {
  private static Button sendButton;

  public SendButton() {
    sendButton = RoundButtonFactory.createButton("\u2191");

    setActions();
    getChildren().add(sendButton);
  }

  private static void setActions() {
    sendButton.setOnMouseClicked(event -> TextInputField.sendText(TextInputField.getText()));
  }
}
