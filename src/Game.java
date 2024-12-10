
public class Game {

    public Game(){

    }


    public static void main(String[] args) {

        Dice die1 = new Dice(6);

        die1.showDieFace();

        die1.rollXTimes(100);


    }

}
