import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    Rules rules;
    ArrayList<Dice> diceList;
    Player player;

    public Game() {
        Scanner scanner = new Scanner(System.in);

        player = new Player();
        System.out.print("Welcome! \nUsername: " );
        String username = scanner.nextLine();
        player.setUsername(username);
        showColorOptions();
        int colorOption = scanner.nextInt();
        player.setColor(color);

        while (true) {
            showMenu();
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1: //Play
                    throwDice();
                    break;
                case 2: //Highscore
                    break;
                case 3: //Rules
                    if (rules == null) {
                        rules = new Rules();
                    }
                    rules.printRules();
                    break;
                case 4: //Exit
                    System.out.println("Thank you for playing!");
                    System.exit(0);
            }
        }
    }

    private void showMenu() {
        System.out.println("""
                Menu:
                1.Play
                2.Highscore
                3.Rules
                4.Exit""");
    }

    private void showColorOptions() {
        System.out.println("""
                Please choose a color:
                1. Red
                2. Green
                3. Blue""");
    }

    private void throwDice() {

        /*
        * insert If-sats för att kolla ifall Dice-listan är tom.
        * Om ja - lägg in tärningar. If else, gör inget.
        */

        //Loopar 3 gånger för 3 kast
        for (int i = 0; i < 3; i++) {
            //Ställer om round score till 0 efter varje kast
            int roundScore = 0;

            //Loopar genom listan med tärningar, "rullar dem" och skriver ut resultat
            for (int j = 0; i < diceList.size() - 1; j++) {
                diceList.get(j).rollDice();
                System.out.println("Dice " + (j + 1) + ": " + diceList.get(j).getValue());
                roundScore += diceList.get(j).getValue();
            }

            //Skriver ut poängställning
            System.out.println("Round score: " + roundScore +
                    "\nTotal score: " + player.getScore());
            player.addScore(roundScore);

        }
    }

    public static void main(String[] args) {
        new Game();
    }

}
