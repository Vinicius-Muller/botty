package botty.ui.text;

import botty.ui.commons.LayoutContext;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class UserText extends StackPane {
  private static Text text;

  public static Text getUserTextComponent() {
    return text;
  }

  public static final void renderUserText(String text) {
    Text textMessage = createUserText(text);
    createTextContainer(textMessage);
  }

  public static final void createFadeAnimation(Text textMessage) {
    textMessage.setOpacity(0);
    javafx.animation.FadeTransition fade = new javafx.animation.FadeTransition(javafx.util.Duration.millis(200),
        textMessage);
    fade.setFromValue(0);
    fade.setToValue(1);
    fade.play();
  }

  private static final Text createUserText(String text) {
    Text textMessage = new Text(text);
    textMessage.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
    textMessage.setWrappingWidth(500);
    textMessage.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
    textMessage.setFill(Color.web("#777174"));
    VBox.setMargin(textMessage, new Insets(10, 0, 10, 0));
    textMessage.setStyle("");

    createFadeAnimation(textMessage);

    return textMessage;
  }

  private static final void createTextContainer(Text textMessage) {
    VBox textContainer = new VBox(5);
    textContainer.setAlignment(javafx.geometry.Pos.CENTER);

    VBox.setMargin(textContainer, new Insets(10));
    textContainer.getChildren().addAll(textMessage);

    LayoutContext.getLayoutContext().getChildren().add(0, textContainer);
  }
}
