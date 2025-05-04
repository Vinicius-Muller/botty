package botty.botty;

import botty.botty.ui.TextField.TextInputField;
import botty.botty.ui.label.TextController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
  private static VBox layout;

  private static VBox layout() {
    layout = new VBox(10);
    layout.setAlignment(javafx.geometry.Pos.TOP_CENTER);
    layout.setPadding(new Insets(20));
    layout.setStyle("-fx-background-color: white;");
    return layout;
  }

  @Override
  public void start(Stage primaryStage) {
    TextController title = new TextController("What do you want to translate ?", "TITLE", (byte) 30);
    TextInputField textField = new TextInputField();

    VBox layout = layout();
    layout.getChildren().addAll(title, textField);
    javafx.scene.control.ScrollPane scrollPane = new javafx.scene.control.ScrollPane(layout);
    scrollPane.setFitToWidth(true);
    scrollPane.setFitToHeight(true);
    Scene scene = new Scene(scrollPane, 600, 500);

    primaryStage.setScene(scene);
    primaryStage.setTitle("JavaFX App");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void renderText(String text) {
    TextController textMessage = new TextController(text, "TEXT", (byte) 20);

    javafx.scene.control.Button copyButton = new javafx.scene.control.Button("Copy");
    copyButton.setOnAction(event -> {
      javafx.scene.input.Clipboard clipboard = javafx.scene.input.Clipboard.getSystemClipboard();
      javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
      content.putString(text);
      clipboard.setContent(content);
    });

    VBox textContainer = new VBox(5);
    textContainer.setAlignment(javafx.geometry.Pos.CENTER);
    textMessage.setMaxWidth(550);
    textContainer.getChildren().addAll(textMessage, copyButton);

    layout.getChildren().add(textContainer);
  }

  public static void main(String[] args) {
    launch();
  }
}
