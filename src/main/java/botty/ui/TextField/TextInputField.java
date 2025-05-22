package botty.ui.TextField;

import botty.ui.commons.LayoutContext;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextArea;

public class TextInputField extends StackPane {
  private static TextArea textArea;

  public TextInputField(String placeholder) {
    textArea = new TextArea();
    textArea.setPromptText(placeholder);

    getStyles();

    setActions();

    getChildren().add(textArea);
  }

  private final void getStyles() {
    textArea.setPrefWidth(500);
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

  private final void setActions() {
    textArea.setOnKeyPressed(event -> {
      if (event.getCode().toString().equals("ENTER")) {

        sendText(getText());
      }
    });
  }

  public static final String getText() {
    return textArea.getText();
  }

  public static final void sendText(String textValue) {
    LayoutContext.renderTextUsingMainLayout(textValue);
    textArea.clear();
  }
}