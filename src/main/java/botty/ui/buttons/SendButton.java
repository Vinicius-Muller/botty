package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;

public class SendButton {
  private static ButtonFactory sendButton;

  public static ButtonFactory createSendButton() {
    sendButton = new ButtonFactory(null);

    setStyles();
    setActions();

    return sendButton;
  }

  private final static void setStyles() {
    sendButton.getButton().setPrefWidth(40);
    sendButton.getButton().setPrefHeight(40);
    StackPane.setMargin(sendButton.getButton(), new Insets(0, 0, 22, 0));
    sendButton.getButton().setStyle("-fx-background-color:rgb(0, 0, 0); -fx-background-radius: 40;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\u2191");
    iconLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    iconLabel.setTextFill(javafx.scene.paint.Color.WHITE);
    sendButton.getButton().setGraphic(iconLabel);
  }

  private final static void setActions() {
    sendButton.getButton().setOnMouseClicked(event -> TextInputField.sendText(TextInputField.getText()));
  }
}
