package botty.ui.TextField;

import botty.ui.commons.LayoutContext;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TextArea;

public class TextInputField extends StackPane {
  private TextArea textArea;

  public TextInputField(String placeholder) {
    this.textArea = new TextArea();
    this.textArea.setPromptText(placeholder);

    getStyles();

    setActions();

    getChildren().add(textArea);
  }

  private void getStyles() {
    this.textArea.setPrefWidth(500);
    this.textArea.setStyle(
        "-fx-background-color:rgb(255, 254, 254); " +
            "-fx-border-color: transparent; " +
            "-fx-border-radius: 10px; " +
            "-fx-font-size: 14px; " +
            "-fx-font-family: 'Arial'; " +
            "-fx-text-fill: #333; " +
            "-fx-prompt-text-fill: derive(-fx-control-inner-background, -30%);");
    this.textArea.setWrapText(true);
    this.textArea.setStyle(this.textArea.getStyle() + " -fx-background-radius: 15px; -fx-border-radius: 15px;");
    this.textArea.setPrefRowCount(1);
    this.textArea.setStyle(this.textArea.getStyle() +
        " -fx-background-color:rgb(226, 226, 230); " +
        " -fx-border-color: rgb(226, 226, 230); " +
        " -fx-border-radius: 8px; " +
        " -fx-background-radius: 8px; " +
        " -fx-font-size: 16px; " +
        " -fx-font-family: 'Arial'; " +
        " -fx-text-fill:rgb(78, 77, 77); " +
        " -fx-prompt-text-fill: rgb(226, 226, 230);");
    this.textArea.setPrefColumnCount(1);
    this.textArea.setStyle(this.textArea.getStyle() + " -fx-text-alignment: center; -fx-alignment: center;");
  }

  private void setActions() {
    this.textArea.setOnKeyPressed(event -> {
      if (event.getCode().toString().equals("ENTER")) {
        String textValue = this.textArea.getText();
        LayoutContext.renderTextUsingMainLayout(textValue);
        this.textArea.clear();
      }
    });
  }
}