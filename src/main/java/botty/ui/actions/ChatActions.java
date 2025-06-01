package botty.ui.actions;

import botty.ui.buttons.AudioButton;
import javafx.scene.layout.HBox;

public class ChatActions {
  private static HBox chatContainer;
  
  public static HBox createChatActions() {
    chatContainer = new HBox();

    AudioButton audioButton = new AudioButton();
    chatContainer.getChildren().add(audioButton);
    chatContainer.setSpacing(10);
    chatContainer.setStyle("-fx-alignment: center-right;");
    return chatContainer;
  }
}
