package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class SendButton extends StackPane{
  private static Button sendButton;

  public SendButton() {
    sendButton = new Button(null);

    setStyles();
    setActions();
    getChildren().add(sendButton);
  }

  private static void setStyles() {
    sendButton.setPrefWidth(40);
    sendButton.setPrefHeight(40);
    StackPane.setMargin(sendButton, new Insets(0, 0, 22, 0));
    sendButton.setStyle("-fx-background-color:rgb(0, 0, 0); -fx-background-radius: 40;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\u2191");
    iconLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    iconLabel.setTextFill(javafx.scene.paint.Color.WHITE);
    sendButton.setGraphic(iconLabel);
  }

  private static void setActions() {
    sendButton.setOnMouseClicked(event -> TextInputField.sendText(TextInputField.getText()));
  }
}
