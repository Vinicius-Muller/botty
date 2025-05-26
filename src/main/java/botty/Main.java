package botty;

import botty.ai.ChatPost;
import botty.ui.TextField.TextInputField;
import botty.ui.commons.LayoutContext;
import botty.ui.text.TitleText;
import javafx.application.Application;
import javafx.scene.Scene;
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
    javafx.scene.control.ScrollPane scrollPane = new javafx.scene.control.ScrollPane(LayoutContext.getLayoutContext());

    scrollPane.setFitToWidth(true);
    scrollPane.setFitToHeight(true);
    Scene scene = new Scene(scrollPane, 600, 500);

    primaryStage.setTitle("Botty");
    primaryStage.setScene(scene);
    primaryStage.getScene().getRoot().setStyle("-fx-background-color: white;");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
