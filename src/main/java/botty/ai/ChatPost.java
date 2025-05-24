package botty.ai;

import java.util.List;
import com.cohere.api.Cohere;
import com.cohere.api.requests.ChatRequest;
import com.cohere.api.types.Message;
import com.cohere.api.types.NonStreamedChatResponse;

public class ChatPost {
  public static String getChatResponse(String userMessage, List<Message> history) {
    Cohere cohere = Cohere.builder()
        .token("your cohere token")
        .clientName("snippet")
        .build();

    NonStreamedChatResponse response = cohere.chat(
        ChatRequest.builder()
            .message(userMessage)
            .chatHistory(history)
            .build());

    return response.getText();
  }
}
