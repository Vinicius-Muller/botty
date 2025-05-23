package botty.ui.buttons;

import javafx.scene.layout.StackPane;

public class CopyButton extends StackPane {
  private final ButtonFactory copyButton;
  private static String clipboardText;

  public CopyButton(String text) {
    clipboardText = text;
    copyButton = new ButtonFactory("Copy");

    setStyles();
    setActions();

    getChildren().add(copyButton);
  }

  public final void setActions() {
    this.copyButton.getButton().setOnAction(event -> {
      javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
      javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();

      content.putString(clipboardText);
      clipboard.setContent(content);
    });
  }

  public final void setStyles() {
    this.copyButton.getButton().setPrefWidth(25);
    this.copyButton.getButton().setPrefHeight(25);
    this.copyButton.getButton().setStyle(
        "-fx-background-color: rgb(255, 255, 255); " +
            "-fx-background-radius: 100; " +
            "-fx-border-color: black; " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 100;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\uD83D\uDCCB");
    iconLabel.setTextFill(javafx.scene.paint.Color.BLACK);
    iconLabel.setStyle("-fx-font-size: 10px;");

    StackPane iconPane = new StackPane(iconLabel);
    iconPane.setPrefSize(20, 20);
    iconPane.setAlignment(javafx.geometry.Pos.CENTER);

    this.copyButton.getButton().setGraphic(iconPane);
    this.copyButton.getButton().setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
  }
}
