import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Dice {

    private int pips;
    private int sides;



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



    public void reRollAll(List<Dice> dice) {
        for (Dice die : dice) {
            die.rollDice();
        }
    }


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
