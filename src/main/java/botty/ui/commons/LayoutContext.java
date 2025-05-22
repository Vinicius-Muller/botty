package botty.ui.commons;

import botty.enums.Kinds;
import botty.ui.buttons.CopyButton;
import botty.ui.label.TextController;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class LayoutContext {
  private static VBox layout;

  public static void initializeLayoutContext() {
    layout = new VBox(10);
    layout.setPadding(new Insets(20));
    layout.setStyle(
        "-fx-border-width: 0 0 0 8;" +
            "-fx-border-color: transparent transparent transparent #90ee90;" +
            "-fx-background-color: white;");
    layout.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
  }

  public static VBox getLayoutContext() {
    return layout;
  }

  public static final void renderTextUsingMainLayout(String text) {
    TextController textMessage = new TextController(text, Kinds.TEXT.getKindValue(), (byte) 15);
    CopyButton copyButton = new CopyButton(text);

    VBox textContainer = new VBox(5);
    textContainer.setAlignment(javafx.geometry.Pos.CENTER);
    VBox.setMargin(textContainer, new Insets(10));

    textMessage.setMaxWidth(550);
    textContainer.getChildren().addAll(textMessage, copyButton);

    layout.getChildren().add(0, textContainer);
  }
}