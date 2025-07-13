package botty.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

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
    this.copyButton.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-background-radius: 100; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 100; -fx-cursor: hand");

   setIcon();

    this.copyButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
    this.copyButton.setMinSize(20, 20);
    this.copyButton.setMaxSize(20, 20);
    this.copyButton.setPrefSize(20, 20);
  }

  private void setIcon() {
    FontIcon copyIcon = new FontIcon(MaterialDesign.MDI_CONTENT_COPY);
    copyIcon.setIconSize(16);
    copyIcon.setIconColor(Color.BLACK);
    this.copyButton.setGraphic(copyIcon);
  }
}
