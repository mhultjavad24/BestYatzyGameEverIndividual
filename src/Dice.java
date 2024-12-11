import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Dice {

    private int pips;
    private int sides;

//    public Dice(int sides) {
//        this.pips = 1;               //Kanske bör vara 0 för att visa att tärningen inte blivit rullad
//        this.sides = sides;
//    }

    public Dice(){
        loadProperties();
        rollDice();
    }

    public static List<Dice> getDice(int amountOfDice){
        List<Dice> dice = new ArrayList<Dice>();
        for(int i = 0; i < amountOfDice; i++){
            dice.add(new Dice());
        }
        return dice;
    }

    public void rollDice() {
        Random rng = new Random();
        this.pips = rng.nextInt(sides) + 1;
    }

//    public void rollXTimes(int times) {
//        Random rng = new Random();
//        for (int i = 0; i < times; i++) {
//            rollDice();
//            System.out.println(""+pips);
//        }
//    }

    public void reRollAll(List<Dice> dice) {
        for (Dice die : dice) {
            die.rollDice();
        }
    }

//    public void reRollSome(List<Dice> dice, List<Integer> selectedDice) {
//        for (Integer i : selectedDice) {
//            dice.get(selectedDice.get(i)).rollDice();
//        }
//    }

//    public void showDieFace() { //detta är unicode 16.0 jaga vesrion 22 stöder upp till 15 om jag förstår det rätt
//        switch (this.pips){
//            case 1:
//                System.out.println("⚀");
//                break;
//            case 2:
//                System.out.println("⚁");
//                break;
//            case 3:
//                System.out.println("⚂");
//                break;
//            case 4:
//                System.out.println("⚃");
//                break;
//            case 5:
//                System.out.println("⚄");
//                break;
//            case 6:
//                System.out.println("⚅");
//                break;
//        }
//    }

    public void loadProperties(){
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("src/Dice.properties"));
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Kunde inte läsa properties");
        }
        this.sides = Integer.parseInt(properties.getProperty("sides", "6"));
    }

    public int getPips() {
        return pips;
    }
}
