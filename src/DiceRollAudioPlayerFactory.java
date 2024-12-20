public class DiceRollAudioPlayerFactory implements AudioPlayerFactory {
    @Override
    public AudioPlayer createAudioPlayer() {
        return new AudioPlayer("dice.wav");
    }
}
