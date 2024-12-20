import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Rules rules;
    private List<Dice> diceList;
    private Player player;
    private HighScore highScore;
    private Scanner scanner = new Scanner(System.in);
    private static int bonus_value = 50;

    public Game() {

        highScore = HighScore.getInstance();
        player = new Player();
        System.out.print("Welcome! \nUsername: ");
        String username = scanner.nextLine();
        player.setName(username);
        showColorOptions();
        int colorOption = scanner.nextInt();
        player.setColor(colorOption);

        while (true) {
            showMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1: // Play
                    throwDice();
                    break;
                case 2: // Highscore
                    highScore.printHighScore();
                    break;
                case 3: // Rules
                    if (rules == null) {
                        rules = Rules.getRules();
                    }
                    rules.printRules();
                    break;
                case 4: // Show Current Score
                    showCurrentScore();
                    break;
                case 5: // Change Color
                    showColorOptions();
                    colorOption = scanner.nextInt();
                    player.setColor(colorOption);
                    break;
                case 6: // Exit
                    System.out.println("Thank you for playing!");
                    System.exit(0);
            }
        }
    }

    private void showCurrentScore() {
        List<Integer> sessionScores = player.getSessionScores();
        int lastScore = sessionScores.getLast();
        int highestScore = lastScore;
        int highestIndex = sessionScores.size() - 1;

        for (int i = 0; i < sessionScores.size() - 1; i++) {
            if (sessionScores.get(i) > highestScore) {
                highestScore = sessionScores.get(i);
                highestIndex = i;
            }
        }

        if (highestIndex == sessionScores.size() - 1) {
            AudioPlayerFactory factory = new CelebrationAudioPlayerFactory();
            AudioPlayer audioPlayer = factory.createAudioPlayer();
            audioPlayer.playSound();
            System.out.println("Congratulations! The last roll was the highest: " + lastScore);
        } else {
            System.out.println("Im sorry to say that your last score of " + lastScore + " was not the highest.");
            System.out.println("The highest score was in round " + (highestIndex + 1) + " with a score of " + highestScore);
        }
    }

    private void showMenu() {
        System.out.println("""
                Menu:
                1. Play
                2. Highscore
                3. Rules
                4. Show Current Score
                5. Change Color
                6. Exit""");
    }

    private void showColorOptions() {
        System.out.println("""
                Please choose a color:
                1. Red 
                2. Green
                3. Blue""");
    }

    private void throwDice() {
        //player.setScore(0); //Återställer score efter varje spel.
        AudioPlayerFactory factory = new DiceRollAudioPlayerFactory();
        AudioPlayer audioPlayer = factory.createAudioPlayer();
        audioPlayer.playSound();
        if (diceList == null) {
            diceList = getDice(5);
        }

        //Loopar 3 gånger för 3 kast
        for (int i = 0; i < 3; i++) {
            System.out.println("Throw " + (i + 1) + ":");
            //Ställer om round score till 0 efter varje kast
            int roundScore = 0;

            //Loopar genom listan med tärningar, "rullar dem" och skriver ut resultat
            Dice.reRollAll(diceList);
            System.out.println("Dice rolled: ");
            for (int j = 0; j < diceList.size(); j++) {
                System.out.println(diceList.get(j).getPips() + " ");
                roundScore += diceList.get(j).getPips();
            }

            //Skriver ut poängställning
            player.addScore(roundScore);
            System.out.println("Round score: " + roundScore + "\n");
        }

        int bonus = bonusAmount(diceList);
        player.addScore(bonus);
        System.out.println("Final score: " + player.getScore() + "\n");

        if (bonus > 0) {
            System.out.println("Congratulations on five of a kind! You got a bonus of " + bonus + ". Points");
        }

        this.highScore.addScore(player);
        // need to reset the score when the game is over
        player.resetScore();
    }

    public static List<Dice> getDice(int amountOfDice) {
        List<Dice> dice = new ArrayList<>();
        for (int i = 0; i < amountOfDice; i++) {
            dice.add(new Dice());
        }
        return dice;
    }

    private static int bonusAmount(List<Dice> diceList) {
        if (isBonusWon(diceList)) {
            return bonus_value;
        } else {
            return 0;
        }
    }

    private static boolean isBonusWon(List<Dice> diceList) {

        int firstDice = diceList.get(0).getPips();
        for (Dice d : diceList) {
            if (d.getPips() != firstDice) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        new Game();
    }

}
