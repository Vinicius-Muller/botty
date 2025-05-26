package botty.ui.TextField;

import botty.ai.ChatPost;
import botty.enums.Placeholders;
import botty.ui.buttons.SendButton;
import botty.ui.text.ResponseText;
import botty.ui.text.UserText;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;

public class TextInputField extends StackPane {
  private static TextArea textArea;
  private static HBox inputBox;
  private static AnchorPane anchorPosition;

  public static final void renderTextField() {
    textArea = new TextArea();
    textArea.setPromptText(Placeholders.TRANSLATORTEXTFIELD.getText());

    setStyles();
    setActions();

    createAnchorPosition();
    createInputBox();
  }

  private static final void createInputBox() {
    textArea = new TextArea();
    textArea.setPromptText(Placeholders.TRANSLATORTEXTFIELD.getText());
    textArea.setPrefHeight(80);
    HBox.setHgrow(textArea, Priority.ALWAYS);

    SendButton sendButton = new SendButton();

    inputBox = new HBox(textArea, sendButton);
    inputBox.setPadding(new Insets(20));
    inputBox.setMaxHeight(100);
    inputBox.setSpacing(10);
    inputBox.setMaxWidth(800);
    inputBox.setAlignment(javafx.geometry.Pos.CENTER);

    StackPane centeringWrapper = new StackPane(inputBox);
    centeringWrapper.setPrefWidth(Double.MAX_VALUE);
    StackPane.setAlignment(inputBox, javafx.geometry.Pos.CENTER);

    AnchorPane.setBottomAnchor(centeringWrapper, 10.0);
    AnchorPane.setLeftAnchor(centeringWrapper, 0.0);
    AnchorPane.setRightAnchor(centeringWrapper, 0.0);

    anchorPosition.getChildren().add(centeringWrapper);
  }

  private static final void setStyles() {
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

  private static final void setActions() {
    textArea.setOnKeyPressed(event -> {
      if (event.getCode().toString().equals("ENTER")) {

        sendText(getText());
      }
    });
  }

  private static final void createAnchorPosition() {
    anchorPosition = new AnchorPane();

    AnchorPane.setBottomAnchor(anchorPosition, 10.0);
    AnchorPane.setLeftAnchor(anchorPosition, 20.0);
  }

  public static final void sendText(String textValue) {
    try {
      renderUserText(textValue);
      startNewThreadToSendChatText(textValue);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static final void renderUserText(String textValue) {
    UserText.renderUserText(textValue);
    javafx.application.Platform.runLater(() -> textArea.clear());
  }

  private static final void startNewThreadToSendChatText(String textValue) {
    new Thread(() -> {
      try {
        String apiResponse = ChatPost.getChatResponse(textValue);
        javafx.application.Platform.runLater(() -> {
          ResponseText.renderResponseText(apiResponse);
        });
      } catch (Exception e) {
        e.printStackTrace();
      }
    }).start();
  }

  public static final AnchorPane getTexfieldAnchor() {
    return anchorPosition;
  }

  public static final HBox getInputBox() {
    return inputBox;
  }

  public static final String getText() {
    return textArea.getText();
  }

}