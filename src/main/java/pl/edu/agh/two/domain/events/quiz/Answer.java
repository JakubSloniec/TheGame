package pl.edu.agh.two.domain.events.quiz;

public class Answer {
    private final String text;
    private final int points;

    public Answer(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getText() {
        return text;
    }
}
