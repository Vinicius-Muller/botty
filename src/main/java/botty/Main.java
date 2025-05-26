package botty;

import botty.ai.ChatPost;
import botty.ui.TextField.TextInputField;
import botty.ui.commons.LayoutContext;
import botty.ui.text.TitleText;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public final void start(Stage primaryStage) {
    LayoutContext.initializeLayoutContext();

    renderUiElements();
    renderUiContext(primaryStage);

    ChatPost.setCohereEntity();
  }

  private final static void renderUiElements() {
    TextInputField.renderTextField();
    LayoutContext.getLayoutContext().getChildren().addAll(TitleText.getTitleComponent(), TextInputField.getTexfieldAnchor());
  }

private final static void renderUiContext(Stage primaryStage) {
  ScrollPane scrollPane = new ScrollPane(LayoutContext.getLayoutContext());
  scrollPane.setFitToWidth(true);

  scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
  scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

  scrollPane.setStyle("-fx-background: white;");
  BorderPane root = new BorderPane();
  root.setCenter(scrollPane);
  root.setBottom(TextInputField.getInputBox());

  Scene scene = new Scene(root, 600, 500);
  primaryStage.setTitle("Botty");
  primaryStage.setScene(scene);
  scene.getRoot().setStyle("-fx-background-color: white; -fx-border-color: transparent; -fx-padding: 0;");
  primaryStage.show();
}


  public static void main(String[] args) {
    launch();
  }
}
