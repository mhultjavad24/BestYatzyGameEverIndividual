import java.util.Random;

public class Dice {

    private int pips;
    private int sides;

    public Dice(int sides) {
        pips = 1;
        this.sides = sides;
    }

    public void rollDice() {
        Random rng = new Random();
        this.pips = rng.nextInt(6) + 1;
    }

    public void showDieFace() {
        if (pips == 1){
            System.out.println("\\u{2680}");
        }else if (pips == 2){
            System.out.println("\\u{2681}");
        }else if (pips == 3){
            System.out.println("\\u{2682}");
        }else if (pips == 4){
            System.out.println("\\u{2683}");
        }else if (pips == 5){
            System.out.println("\\u{2684}");
        }else if (pips == 6){
            System.out.println("\\u{2685}");
        }
    }

}
