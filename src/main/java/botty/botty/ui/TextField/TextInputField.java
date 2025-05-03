package botty.botty.ui.TextField;

import javafx.scene.layout.StackPane;
import botty.botty.Main;
import javafx.scene.control.TextField;

public class TextInputField extends StackPane {
  TextField textField;

  public TextInputField() {
    textField = new TextField();
    textField.setPromptText("Enter text here");
    textField.setPrefHeight(40);

    textField.setOnAction(event -> {
      String textValue = textField.getText();
      System.out.println("Entered text: " + textValue);
      textField.clear();
    });

    getChildren().add(textField);

    textField.setOnAction(event -> {
      String textValue = textField.getText();
      Main.renderText(textValue);
      textField.clear();
    });
  }
}