import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    Rules rules;
    ArrayList<Dice> diceList;
    Player player;

    public Game() {
        Scanner scanner = new Scanner(System.in);

        player = new Player();
        System.out.print("Welcome!\nUsername: ");
        String username = scanner.nextLine();
//            player.setUsername(username);
        showColorOptions();
        String color = scanner.nextLine();
//            player.setColor(color);

        while (true) {
            showMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    //Starta spel
                    break;
                case 2:
                    //Se highscore
                    break;
                case 3:
                    if (rules == null) {
                        rules = new Rules();
                    }
                    System.out.println(rules.getRules());
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                    Menu:
                    1.Play
                    2.Highscore
                    3.Rules""");
    }

    private void showColorOptions() {
        System.out.println("""
                Please choose a color:
                1. Red
                2. Green
                3. Blue""");
    }

    private void showDice() {

        int roundScore = 0;

        for (int i = 0; i < diceList.size() - 1; i++) {
            diceList.get(i).rollDice();
            System.out.println("Dice " + (i + 1) + ": " + diceList.get(i).getValue());
            roundScore += diceList.get(i).getValue();
        }

        System.out.println("Round score: " + roundScore +
                "\nTotal score: " + player.getScore());
        player.addScore(roundScore);

    }

    public static void main(String[] args) {
        new Game();
    }

}
