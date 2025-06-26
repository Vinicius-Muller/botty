package botty.ui.buttons.factories;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class RoundButtonFactory {
  private static Button sendButton;

  public static Button createButton(String icon) {
    sendButton = new Button(null);

    setStyles(icon);
    return sendButton;
  }

  private static void setStyles(String icon) {
    sendButton.setPrefWidth(40);
    sendButton.setPrefHeight(40);
    StackPane.setMargin(sendButton, new Insets(0, 0, 22, 0));
    sendButton.setStyle("-fx-background-color:rgb(0, 0, 0); -fx-background-radius: 40;");

    Label iconLabel = new Label(icon);
    iconLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
    iconLabel.setTextFill(javafx.scene.paint.Color.WHITE);
    sendButton.setGraphic(iconLabel);
  }
}
