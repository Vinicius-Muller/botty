package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import javafx.scene.layout.StackPane;

public class AudioButton extends StackPane {
  private static ButtonFactory audioButton;

  public AudioButton() {
    audioButton = new ButtonFactory("Copy");

    setStyles();
    setActions();

    getChildren().add(audioButton);
  }

  public final void setActions() {
    audioButton.getButton().setOnAction(event -> {
      System.out.println("clicked");

      TextInputField.getInputBox().setOpacity(0.4);
    });
  }

  public final void setStyles() {
    audioButton.getButton().setStyle(
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

    audioButton.getButton().setGraphic(iconPane);
    audioButton.getButton().setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
    audioButton.getButton().setMinSize(20, 20);
    audioButton.getButton().setMaxSize(20, 20);
    audioButton.getButton().setPrefSize(20, 20);
  }
}
