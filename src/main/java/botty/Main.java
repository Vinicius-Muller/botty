package botty;

import botty.ai.ChatPost;
import botty.ui.TextField.TextInputField;
import botty.ui.buttons.factories.RoundButtonFactory;
import botty.ui.commons.LayoutContext;
import botty.ui.text.TitleText;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public final void start(Stage primaryStage) {
    LayoutContext.initializeLayoutContext();

    renderUiElements();
    renderUiContext(primaryStage);

    ChatPost.setCohereEntity();
  }

  private static void renderUiElements() {
    TitleText mainTitle = new TitleText();
    TextInputField mainTextField = new TextInputField();

    LayoutContext.addMultipleChilds(
        mainTitle.getTitleStackPane(),
        mainTextField.getTexfieldAnchor());
  }

  private void renderUiContext(Stage primaryStage) {
    ScrollPane scrollPane = new ScrollPane(LayoutContext.getLayoutContext());
    scrollPane.setFitToWidth(true);

    scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

    scrollPane
        .setStyle(
            "-fx-background: white; -fx-border-color: transparent; -fx-background-insets: 0; -fx-padding: 0;");

    BorderPane root = new BorderPane();
    root.setCenter(scrollPane);

    createBottomControls(root);
    createIncognitoButton(root);

    Scene scene = new Scene(root, 700, 600);
    primaryStage.setTitle("Botty");
    primaryStage.setScene(scene);
    scene.getRoot().setStyle("-fx-background-color: white; -fx-border-color: transparent; -fx-padding: 0;");
    primaryStage.show();
  }

  public void createIncognitoButton(BorderPane root) {
    HBox container = new HBox(RoundButtonFactory.createButton("\uD83D\uDD12"));
    container.setPadding(new Insets(10));
    // set the actions to activate the incognito mode
    root.setRight(container);
  }

  public void createBottomControls(BorderPane root) {
    HBox bottomWrapper = new HBox(TextInputField.getInputBox());
    bottomWrapper.setAlignment(javafx.geometry.Pos.CENTER);
    bottomWrapper.setPadding(new Insets(10));
    bottomWrapper.setStyle("-fx-background-color: white;");

    root.setBottom(bottomWrapper);
  }

  public static void main(String[] args) {
    launch();
  }
}
