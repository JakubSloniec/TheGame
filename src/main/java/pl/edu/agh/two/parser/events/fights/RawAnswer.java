package pl.edu.agh.two.parser.events.fights;

/**
 * Created by Michal Mrowczyk on 12/1/2015.
 */
public class RawAnswer {
    private String answer;
    private int points;
    private String reaction;

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

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }
}
