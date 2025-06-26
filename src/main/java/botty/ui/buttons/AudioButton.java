package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AudioButton extends StackPane {
  private static Button audioButton;

  public AudioButton() {
    audioButton = new Button("Copy");

    setStyles();
    setActions();

    getChildren().add(audioButton);
  }

  public final void setActions() {
    audioButton.setOnAction(event -> {
      VBox container = TextInputField.getTextAreaContainer();
      container.setStyle("-fx-background-color: transparent; -fx-opacity: 0.5; -fx-background-insets: 0; -fx-background-radius: 0;");
      container.setMouseTransparent(true);

      SendButton sendButton = TextInputField.getSendButton();
      TextInputField.removeButton(sendButton);

      MicrophoneButton microphoneButton = new MicrophoneButton();
      TextInputField.addbutton(microphoneButton);
    });
  }

  public final void setStyles() {
    audioButton.setStyle(
        "-fx-background-color: rgb(255, 255, 255); " +
            "-fx-background-radius: 100; " +
            "-fx-border-color: black; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 100;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\uD83C\uDFA4");
    iconLabel.setTextFill(javafx.scene.paint.Color.BLACK);
    iconLabel.setStyle("-fx-font-size: 8px;");

    StackPane iconPane = new StackPane(iconLabel);
    iconPane.setPrefSize(20, 20);
    iconPane.setAlignment(javafx.geometry.Pos.CENTER);

    audioButton.setGraphic(iconPane);
    audioButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
    audioButton.setMinSize(20, 20);
    audioButton.setMaxSize(20, 20);
    audioButton.setPrefSize(20, 20);
  }
}
