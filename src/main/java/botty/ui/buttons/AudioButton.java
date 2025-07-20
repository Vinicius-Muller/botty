package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

public class AudioButton extends StackPane {
  private final Button audioButton;
  private Button closeAudioStateButton;

  public AudioButton() {
    this.audioButton = new Button("Copy");

    setStyles();
    setActions();

    getChildren().add(this.audioButton);
  }

  public final void setActions() {
    this.audioButton.setOnAction(event -> {
      VBox container = TextInputField.getTextAreaContainer();
      container.setStyle("-fx-background-color: transparent; -fx-opacity: 0.5; -fx-background-insets: 0; -fx-background-radius: 0;");
      container.setMouseTransparent(true);

      SendButton sendButton = TextInputField.getSendButton();
      TextInputField.removeButton(sendButton);

      MicrophoneButton microphoneButton = new MicrophoneButton();
      HBox micContainer = new HBox(microphoneButton);
      this.createCloseButton(micContainer);
      TextInputField.addbutton(micContainer);
    });
  }

  public final void setStyles() {
    this.audioButton.setStyle(
        "-fx-background-color: rgb(255, 255, 255); -fx-background-radius: 100; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 100; -fx-cursor: hand");

    this.setIcon();

    this.audioButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
    this.audioButton.setMinSize(20, 20);
    this.audioButton.setMaxSize(20, 20);
    this.audioButton.setPrefSize(20, 20);
  }

  private void setIcon() {
    FontIcon micIcon = new FontIcon(MaterialDesign.MDI_MICROPHONE);
    micIcon.setIconSize(16);
    micIcon.setIconColor(Color.BLACK);
    this.audioButton.setGraphic(micIcon);
  }

  private void createCloseButton(HBox container) {
    this.closeAudioStateButton = new Button();
    FontIcon closeIcon = new FontIcon(MaterialDesign.MDI_CLOSE);
    closeIcon.setIconSize(10);
    closeIcon.setIconColor(Color.BLACK);
    this.closeAudioStateButton.setGraphic(closeIcon);
    this.closeAudioStateButton.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-background-radius: 100; -fx-border-color: black; -fx-border-width: 2; -fx-border-radius: 100; -fx-cursor: hand;");

    this.closeAudioStateButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
    this.closeAudioStateButton.setMinSize(20, 20);
    this.closeAudioStateButton.setMaxSize(20, 20);
    this.closeAudioStateButton.setPrefSize(20, 20);

    this.closeAudioStateButton.setOnAction(event -> {
      this.removeButton();
      this.removeTheVoiceStyleFromTheButton();
    });

    container.getChildren().add(this.closeAudioStateButton);
  }

  private void removeButton() {
    Node buttonsContainer = TextInputField.getInputBox().getChildren().get(1);

    if (buttonsContainer instanceof HBox containerHBox) {
      ObservableList<Node> children = containerHBox.getChildren();
      if (children.size() > 1) {
        Node closeButton = children.get(1);
        containerHBox.getChildren().remove(closeButton);
      }
    }
  }

  private void removeTheVoiceStyleFromTheButton() {
    TextInputField.getInputBox().getChildren().remove(1);
    SendButton sendButton = new SendButton();
    TextInputField.addNewSendButton(sendButton);

    VBox container = TextInputField.getTextAreaContainer();
    container.setStyle("-fx-opacity: 1;");
    container.setMouseTransparent(false);
  }
}
