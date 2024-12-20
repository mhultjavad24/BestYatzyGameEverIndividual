public class CelebrationAudioPlayerFactory implements AudioPlayerFactory {
    @Override
    public AudioPlayer createAudioPlayer() {
        return new AudioPlayer("celebrate.wav");
    }
}
