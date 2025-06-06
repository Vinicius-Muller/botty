package botty.ui.text;

import botty.ui.buttons.CopyButton;
import botty.ui.commons.LayoutContext;
import javafx.geometry.Insets;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Node;

public class ResponseText extends StackPane {
  private static Text text;
  private static VBox textContainer;

  public static Text getResponseTextComponent() {
    return text;
  }

  public static final void renderResponseText(String text) {
    Text textMessage = createResponseText(text);
    CopyButton copyButton = createCopyClipboard(text);
    createTextContainer(textMessage, copyButton);
  }

  public static final void createFadeAnimation(Text textMessage) {
    textMessage.setOpacity(0);
    javafx.animation.FadeTransition fade = new javafx.animation.FadeTransition(javafx.util.Duration.millis(200),
        textMessage);
    fade.setFromValue(0);
    fade.setToValue(1);
    fade.play();
  }

  private static final Text createResponseText(String text) {
    Text textMessage = new Text(text);
    textMessage.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
    textMessage.setWrappingWidth(500);
    textMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

    createFadeAnimation(textMessage);

    return textMessage;
  }

  private static final CopyButton createCopyClipboard(String text) {
    CopyButton copyButton = new CopyButton(text);

    return copyButton;
  }

  private static final void createTextContainer(Text textMessage, CopyButton copyButton) {
    textContainer = new VBox(5);
    textContainer.setAlignment(javafx.geometry.Pos.CENTER);

    VBox.setMargin(textContainer, new Insets(10));
    textContainer.getChildren().addAll(textMessage, copyButton);

    LayoutContext.addChildToPriorityPosition(textContainer);
  }

  public static final VBox getTextContainer() {
    return textContainer;
  }

  public static final void showLoader() {
    ProgressIndicator loader = new ProgressIndicator();
    loader.setStyle("-fx-progress-color: black;");
    loader.setPrefSize(30, 30);
    LayoutContext.addChildToPriorityPosition(loader);
  }

  public static final void hideLoader() {
    Node previousLoader = LayoutContext.getLayoutNode(1);
    if (previousLoader != null) {
      if (previousLoader instanceof ProgressIndicator) {
        int loaderIndex = LayoutContext.getLayoutNodeIndex(previousLoader);
        LayoutContext.deleteLayoutNode(loaderIndex);
      }
      return;
    }
  }
}
