package pl.edu.agh.two.parser.events.quiz;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawAnswer {
    private String answer;
    private int points;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
