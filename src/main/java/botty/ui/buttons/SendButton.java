package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import javafx.scene.layout.StackPane;

public class SendButton extends StackPane {
  private final ButtonFactory sendButton;

  public SendButton() {
    this.sendButton = new ButtonFactory(null);

    setStyles();
    setActions();

    getChildren().add(this.sendButton);
  }

  private final void setStyles() {
    this.sendButton.getButton().setPrefWidth(40);
    this.sendButton.getButton().setPrefHeight(40);
    this.sendButton.getButton().setStyle("-fx-background-color:rgb(0, 0, 0); -fx-background-radius: 40;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\u2191");
    iconLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    iconLabel.setTextFill(javafx.scene.paint.Color.WHITE);
    this.sendButton.getButton().setGraphic(iconLabel);
  }

  private final void setActions() {
    this.sendButton.getButton().setOnMouseClicked(event -> TextInputField.sendText(TextInputField.getText()));
  }
}
