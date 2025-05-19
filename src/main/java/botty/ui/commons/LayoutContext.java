package botty.ui.commons;

import botty.enums.Kinds;
import botty.ui.label.TextController;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class LayoutContext {
  private static VBox layout;

  public static void initializeLayoutContext() {
    layout = new VBox(10);
    layout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
    layout.setPadding(new Insets(20));
    layout.setStyle("-fx-background-color: white;");
  }

  public static VBox getLayoutContext() {
    return layout;
  }

  public static final void renderTextUsingMainLayout(String text) {
    TextController textMessage = new TextController(text, Kinds.TEXT.getKindValue(), (byte) 20);
    javafx.scene.control.Button copyButton = new javafx.scene.control.Button("Copy");

    copyButton.setOnAction(event -> {
      javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
      javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
      content.putString(text);
      clipboard.setContent(content);
    });

    VBox textContainer = new VBox(5);
    textContainer.setAlignment(javafx.geometry.Pos.CENTER);

    textMessage.setMaxWidth(550);
    textContainer.getChildren().addAll(textMessage, copyButton);

    layout.getChildren().add(textContainer);
  }
}