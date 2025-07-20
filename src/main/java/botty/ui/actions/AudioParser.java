package botty.ui.actions;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioParser {
    private TargetDataLine microphone;
    private final AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    private final AudioFormat format;
    private final File wavFile;

    public AudioParser(String filePath) {
        this.format = new AudioFormat(44100, 16, 1, true, false);
        this.wavFile = new File(filePath);
    }

    public void startRecording() {
        try {
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
            if (!AudioSystem.isLineSupported(info)) {
                return;
            }

            this.microphone = (TargetDataLine) AudioSystem.getLine(info);
            this.microphone.open(this.format);
            this.microphone.start();

            Thread recordingThread = new Thread(() -> {
                try (AudioInputStream audioStream = new AudioInputStream(this.microphone)) {
                    AudioSystem.write(audioStream, this.fileType, this.wavFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            recordingThread.start();

        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopRecording() {
        this.microphone.stop();
        this.microphone.close();
    }
}
