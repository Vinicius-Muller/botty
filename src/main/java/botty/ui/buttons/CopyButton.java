package botty.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class CopyButton extends StackPane {
  private final Button copyButton;
  private static String clipboardText;

  public CopyButton(String text) {
    clipboardText = text;
    copyButton = new Button("Copy");

    setStyles();
    setActions();

    getChildren().add(copyButton);
  }

  public final void setActions() {
    this.copyButton.setOnAction(event -> {
      javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
      javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();

      content.putString(clipboardText);
      clipboard.setContent(content);
    });
  }

  public final void setStyles() {
    this.copyButton.setStyle(
        "-fx-background-color: rgb(255, 255, 255); " +
            "-fx-background-radius: 100; " +
            "-fx-border-color: black; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 100;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\uD83D\uDCCB");
    iconLabel.setTextFill(javafx.scene.paint.Color.BLACK);
    iconLabel.setStyle("-fx-font-size: 8px;");

    StackPane iconPane = new StackPane(iconLabel);
    iconPane.setPrefSize(20, 20);
    iconPane.setAlignment(javafx.geometry.Pos.CENTER);

    this.copyButton.setGraphic(iconPane);
    this.copyButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
    this.copyButton.setMinSize(20, 20);
    this.copyButton.setMaxSize(20, 20);
    this.copyButton.setPrefSize(20, 20);
  }
}
