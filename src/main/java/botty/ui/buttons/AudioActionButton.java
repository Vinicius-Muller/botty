package botty.ui.buttons;

import botty.ui.TextField.TextInputField;
import botty.ui.actions.AudioParser;
import botty.ui.buttons.factories.RoundButtonFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
  private final AudioParser audioParser = new AudioParser("audio.wav");

  public AudioActionButton() {
    this.microphoneButton = RoundButtonFactory.createButton("\uD83C\uDFA4");
    this.microphoneButton.setGraphic(iconFactory(MaterialDesign.MDI_MICROPHONE));

    this.microphoneButton.setOnMouseClicked(event -> {
      this.addRecordingLabel();
      this.controlTimelineAudioDuration();
    });

    getChildren().add(this.microphoneButton);
  }

  public void closeRecordingState() {
    this.resetRecordingState();
  }

  private void addRecordingLabel() {
    if (this.recordingText == null) {
      this.recordingText = new Text("Recording: 0.0s");
      this.textContainer = new HBox(this.recordingText);
      this.textContainer.setAlignment(Pos.CENTER);
      TextInputField.getTextAreaContainer().getChildren().add(0, this.textContainer);
    } else {
      this.recordingText.setText("Recording: 0.0s");
    }
  }

  private void controlTimelineAudioDuration() {
    if (this.timeline != null) {
      this.resetRecordingState();
      this.audioParser.stopRecording();
    } else {
      this.audioParser.startRecording();
      this.microphoneButton.setGraphic(iconFactory(MaterialDesign.MDI_STOP));
      this.timeline = new Timeline(
        new KeyFrame(Duration.seconds(1), timelineEvent -> {
          this.audioDuration += 0.1;
          this.recordingText.setText(String.format("Recording: %.1fs", this.audioDuration));
        })
      );
      this.timeline.setCycleCount(Timeline.INDEFINITE);
      this.timeline.play();
    }
  }

  private void resetRecordingState() {
    if(this.timeline != null) {
      this.timeline.stop();
      this.timeline = null;
    }

    if(this.textContainer != null) {
      TextInputField.getTextAreaContainer().getChildren().remove(this.textContainer);
    }

    this.recordingText = null;
    this.audioDuration = 0.0;
    this.microphoneButton.setGraphic(iconFactory(MaterialDesign.MDI_MICROPHONE));

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
