package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.kordamp.ikonli.javafx.FontIcon;
import org.kordamp.ikonli.materialdesign.MaterialDesign;

public class AudioActionButton extends StackPane {
  private final Button microphoneButton;
  private Double audioDuration = 0.0;
  private Timeline timeline;
  private Text recordingText;
  private HBox textContainer;

  public AudioActionButton() {
    this.microphoneButton = RoundButtonFactory.createButton("\uD83C\uDFA4");
    this.microphoneButton.setGraphic(iconFactory(MaterialDesign.MDI_MICROPHONE));

    this.microphoneButton.setOnMouseClicked(event -> {
      this.addRecordingLabel();
      this.controlTimelineAudioDuration();
    });

    getChildren().add(this.microphoneButton);
  }

  private void addRecordingLabel() {
    if (recordingText == null) {
      recordingText = new Text("Recording: 0.0s");
      textContainer = new HBox(recordingText);
      textContainer.setAlignment(Pos.CENTER);
      TextInputField.getTextAreaContainer().getChildren().add(0, textContainer);
    } else {
      recordingText.setText("Recording: 0.0s");
    }
  }

  private void controlTimelineAudioDuration() {
    /*check why toggling the mic button does not work*/
    if (timeline != null) {
      timeline.stop();
      this.microphoneButton.setGraphic(iconFactory(MaterialDesign.MDI_MICROPHONE));
      TextInputField.getTextAreaContainer().getChildren().remove(textContainer);
    } else {
      this.microphoneButton.setGraphic(iconFactory(MaterialDesign.MDI_STOP));
      timeline = new Timeline(
        new KeyFrame(Duration.seconds(1), timelineEvent -> {
          this.audioDuration += 0.1;
          recordingText.setText(String.format("Recording: %.1fs", this.audioDuration));
        })
      );
      timeline.setCycleCount(Timeline.INDEFINITE);
      timeline.play();
    }
  }

  private FontIcon iconFactory(MaterialDesign icon) {
    FontIcon micIcon = new FontIcon(icon);
    micIcon.setIconSize(24);
    micIcon.setIconColor(Color.WHITE);
    return micIcon;
  }

  public Button getMicrophoneButton() {
    return this.microphoneButton;
  }

  public Double getAudioDuration() {
    return this.audioDuration;
  }

}
