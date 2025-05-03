package botty.botty;

import botty.botty.ui.TextField.TextInputField;
import botty.botty.ui.label.Title;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  private static VBox layout() {
    VBox layout = new VBox(10);
    layout.setAlignment(javafx.geometry.Pos.BOTTOM_CENTER);
    layout.setPadding(new Insets(20));
    layout.setStyle("-fx-background-color: white;");
    return layout;
  }

  @Override
  public void start(Stage primaryStage) {
    Title title = new Title();
    TextInputField textField = new TextInputField();

    VBox layout = layout();
    layout.getChildren().addAll(title, textField);
    layout.requestFocus();
    /* user this do delete the title */
    layout.getChildren().remove(0);
    Scene scene = new Scene(layout, 400, 300);

    primaryStage.setTitle("JavaFX App");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void renderText(String text) {
    System.out.println("Entered text: " + text);
  }

  public static void main(String[] args) {
    launch();
  }
}
