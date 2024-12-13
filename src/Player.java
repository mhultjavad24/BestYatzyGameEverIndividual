import java.awt.*;

public class Player extends Person {
    private String color;
    private int score;

    public int getScore() {
        return score;
    }

    public void addScore(int addedScore) {
        score += addedScore;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void resetScore() {
        score = 0;
    }

    public String getColor() {
        this.color = "Green";
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.name + " " + "(" + this.getColor().toUpperCase() +")" + ": " + this.score;
    }
}
