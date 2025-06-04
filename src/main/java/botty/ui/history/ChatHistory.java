package botty.ui.history;

import botty.ai.ChatPost;
import botty.ui.commons.LayoutContext;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ChatHistory {
  private static VBox chatHistoryBox;

  public static final void createChatHistoryBox() {
    chatHistoryBox = new VBox(10);
    chatHistoryBox.setAlignment(Pos.TOP_LEFT);
    LayoutContext.addChild(chatHistoryBox);
  }

  public static final void appendChatHistoryListInChatBox() {
    for (String message : ChatPost.getHistory()) {
      javafx.scene.text.Text text = new javafx.scene.text.Text(message);
      chatHistoryBox.getChildren().add(text);
    }
  }
}
