package botty.ui.buttons;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ButtonFactory extends StackPane {
  private Button button;

  public ButtonFactory(String placeholder) {
    this.button = new Button(placeholder);

    getStyles();

    getChildren().add(this.button);
  }

  private void getStyles() {
    this.button.setPrefWidth(40);
    this.button.setPrefHeight(40);
    this.button.setStyle("-fx-background-color: #90ee90; -fx-background-radius: 40;");

    javafx.scene.control.Label iconLabel = new javafx.scene.control.Label("\u2191");
    iconLabel.setStyle("-fx-font-size: 18px;");

    this.button.setGraphic(iconLabel);
  }
}