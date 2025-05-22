package botty;

import botty.enums.Kinds;
import botty.enums.Placeholders;
import botty.ui.TextField.TextInputField;
import botty.ui.buttons.SendButton;
import botty.ui.commons.LayoutContext;
import botty.ui.label.TextController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    LayoutContext.initializeLayoutContext();

    TextController title = new TextController(Placeholders.TITLE.getText(), Kinds.TITLE.getKindValue(), (byte) 15);
    TextInputField textField = new TextInputField(Placeholders.TRANSLATORTEXTFIELD.getText());
    SendButton sendButton = new SendButton();

    javafx.scene.layout.HBox inputBox = new javafx.scene.layout.HBox(10, textField, sendButton);

    LayoutContext.getLayoutContext().getChildren().addAll(title, inputBox);
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
