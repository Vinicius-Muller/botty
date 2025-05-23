package botty;

import botty.enums.Kinds;
import botty.enums.Placeholders;
import botty.ui.TextField.TextInputField;
import botty.ui.buttons.SendButton;
import botty.ui.commons.LayoutContext;
import botty.ui.label.TextController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public final void start(Stage primaryStage) {
    LayoutContext.initializeLayoutContext();

    renderUiElements();

    renderUiContext(primaryStage);
  }

  private final static void renderUiElements() {
    TextController title = new TextController(Placeholders.TITLE.getText(), Kinds.TITLE.getKindValue(), (byte) 15);
    TextInputField textField = new TextInputField(Placeholders.TRANSLATORTEXTFIELD.getText());
    SendButton sendButton = new SendButton();

    javafx.scene.layout.HBox inputBox = new javafx.scene.layout.HBox(10, textField, sendButton);
    inputBox.setPrefWidth(Double.MAX_VALUE);
    HBox.setHgrow(textField, Priority.ALWAYS);
    textField.prefWidthProperty().bind(inputBox.widthProperty().multiply(0.8));
    sendButton.setPrefWidth(60);
    LayoutContext.getLayoutContext().getChildren().addAll(title, inputBox);
  }

  private final static void renderUiContext(Stage primaryStage) {
    javafx.scene.control.ScrollPane scrollPane = new javafx.scene.control.ScrollPane(LayoutContext.getLayoutContext());

    scrollPane.setFitToWidth(true);
    scrollPane.setFitToHeight(true);
    Scene scene = new Scene(scrollPane, 600, 500);

    primaryStage.setTitle("Botty");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
