import java.util.ArrayList;
import java.util.List;

public class Player extends Person {
    private String color;
    private int score;
    private List<Integer> sessionScores = new ArrayList<Integer>();

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
        this.sessionScores.add(score);
        score = 0;
    }

    public String getColorCode() {
        return switch (color) {
            case "RED" -> "\u001B[31m";
            case "GREEN" -> "\u001B[32m";
            case "BLUE" -> "\u001B[34m";
            default -> "\u001B[0m";
        };
    }

    public void setColor(Integer color) {
        if (color == 1) {
            this.color = "RED";
        } else if (color == 2) {
            this.color = "GREEN";
        } else if (color == 3) {
            this.color = "BLUE";
        }
    }

    @Override
    public String toString() {
        return this.name + "," + color +"," + this.score;
    }

    public java.util.List<Integer> getSessionScores() {
        return sessionScores;
    }
}
