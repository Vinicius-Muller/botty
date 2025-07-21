package botty.ui.TextField;

import botty.ai.ChatPost;
import botty.enums.Placeholders;
import botty.ui.actions.ChatActions;
import botty.ui.buttons.SendButton;
import botty.ui.text.ResponseText;
import botty.ui.text.UserText;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TextInputField extends StackPane {
  private static TextArea textArea;
  private static HBox inputBox;
  private static VBox textAreaContainer;
  private static AnchorPane anchorPosition;
  private static SendButton sendButton;

  public TextInputField() {
    textArea = new TextArea();
    textArea.setPromptText(Placeholders.TRANSLATORTEXTFIELD.getText());

    setStyles();
    createAnchorPosition();
    createInputBox();
  }

  private static void createInputBox() {
    textArea = new TextArea();
    textArea.setPromptText(Placeholders.TRANSLATORTEXTFIELD.getText());


    textAreaContainer = new VBox(textArea, ChatActions.createChatActions());
    textAreaContainer.setSpacing(10);
    HBox.setHgrow(textAreaContainer, Priority.ALWAYS);

    sendButton = new SendButton();
    inputBox = new HBox(textAreaContainer, sendButton);
    inputBox.setPadding(new Insets(20));
    inputBox.setMaxHeight(150);
    inputBox.setSpacing(10);
    inputBox.setMaxWidth(800);
    inputBox.setAlignment(javafx.geometry.Pos.CENTER);

    StackPane centeringWrapper = new StackPane(inputBox);
    centeringWrapper.setPrefWidth(Double.MAX_VALUE);
    StackPane.setAlignment(inputBox, javafx.geometry.Pos.CENTER);

    AnchorPane.setBottomAnchor(centeringWrapper, 10.0);
    AnchorPane.setLeftAnchor(centeringWrapper, 0.0);
    AnchorPane.setRightAnchor(centeringWrapper, 0.0);

    anchorPosition.getChildren().addAll(centeringWrapper);
  }

  private static void setStyles() {
    textArea.setStyle(
        "-fx-background-color:rgb(255, 254, 254); " +
            "-fx-border-color: transparent; " +
            "-fx-border-radius: 10px; " +
            "-fx-font-size: 14px; " +
            "-fx-font-family: 'Arial'; " +
            "-fx-text-fill: #333; " +
            "-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
    textArea.setWrapText(true);
    textArea.setStyle(textArea.getStyle() + " -fx-background-radius: 15px; -fx-border-radius: 15px;");
    textArea.setPrefRowCount(1);
    textArea.setStyle(textArea.getStyle() +
        " -fx-background-color:rgb(226, 226, 230); " +
        " -fx-border-color: rgb(226, 226, 230); " +
        " -fx-border-radius: 8px; " +
        " -fx-background-radius: 8px; " +
        " -fx-font-size: 16px; " +
        " -fx-font-family: 'Arial'; " +
        " -fx-text-fill:rgb(78, 77, 77); " +
        " -fx-prompt-text-fill: rgb(226, 226, 230);");
    textArea.setPrefColumnCount(1);
    textArea.setStyle(textArea.getStyle() + " -fx-text-alignment: center; -fx-alignment: center;");
  }

  private static void createAnchorPosition() {
    anchorPosition = new AnchorPane();

    AnchorPane.setBottomAnchor(anchorPosition, 10.0);
    AnchorPane.setLeftAnchor(anchorPosition, 20.0);
  }

  public static void sendText(String textValue) {
    try {
      renderUserText(textValue);
      startNewThreadToSendChatText(textValue);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  private static void renderUserText(String textValue) {
    UserText.renderUserText(textValue);
    javafx.application.Platform.runLater(() -> textArea.clear());
  }

  private static void startNewThreadToSendChatText(String textValue) {
    new Thread(() -> {
      try {
        javafx.application.Platform.runLater(ResponseText::showLoader);

        String apiResponse = ChatPost.getChatResponse(textValue);
        javafx.application.Platform.runLater(() -> {
          ResponseText.renderResponseText(apiResponse);
        });
      } catch (Exception e) {
        System.out.println(e);
      } finally {
        javafx.application.Platform.runLater(ResponseText::hideLoader);
      }
    }).start();
  }

  public final AnchorPane getTexfieldAnchor() {
    return anchorPosition;
  }

  public static HBox getInputBox() {
    return inputBox;
  }

  public static String getText() {
    return textArea.getText();
  }

  public static TextArea getTextArea() {
    return textArea;
  }

  public static VBox getTextAreaContainer() {
    return textAreaContainer;
  }

  public static SendButton getSendButton() {
    return sendButton;
  }

  public static void removeButton(Node button) {
    inputBox.getChildren().remove(button);
  }

  public static void addbutton(Node button) {
    inputBox.getChildren().add(button);
  }

  public static void addSendButton(SendButton newButton) {
    sendButton = newButton;

    getInputBox().getChildren().add(sendButton);
  }
}