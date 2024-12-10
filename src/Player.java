import java.awt.*;

public class Player extends Person{

    //Den som har hand om färg får bestämma hur man vill ha färger
    private String color;
    private Color color2;
    private int score;

    public int getScore() {
        return score;
    }

    public void addScore(int addedScore) {
        score += addedScore;
    }


}
