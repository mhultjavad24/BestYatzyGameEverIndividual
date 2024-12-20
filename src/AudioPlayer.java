import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private String soundFilePath;

    public AudioPlayer(String soundFilePath) {
        this.soundFilePath = soundFilePath;
    }

    public void playSound() {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            AudioFormat format = audioInputStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip clip = (Clip) AudioSystem.getLine(info);

            clip.open(audioInputStream);

            clip.start();

            clip.addLineListener(new LineListener() {
                @Override
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                }
            });
            while (clip.isRunning()) {
                Thread.sleep(100);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}