package botty.ai;

import java.util.ArrayList;
import java.util.List;

import com.cohere.api.Cohere;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.types.NonStreamedChatResponse;

public class ChatPost {
  private static Cohere cohere;
  private static NonStreamedChatResponse response;
  private static final List<String> history = new ArrayList<>();

  public static final String getChatResponse(String userMessage) {
    setHistory(userMessage);

    handleChatResponse(userMessage);

    return response.getText();
  }

  public static final void setHistory(String userMessage) {
    history.add(userMessage);
  }

  public static final void setCohereEntity() {
    cohere = Cohere.builder()
      .token()
      .clientName("snippet")
      .build();
  }

  private static void handleChatResponse(String userMessage) {
    response = cohere.chat(
        ChatRequest.builder()
            .message(userMessage)
            .build());
  }

  public static final List<String> getHistory() {
    return history;
  }
}
