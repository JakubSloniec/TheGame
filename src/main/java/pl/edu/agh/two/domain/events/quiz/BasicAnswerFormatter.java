package pl.edu.agh.two.domain.events.quiz;

public class BasicAnswerFormatter implements IAnswerFormatter {
    @Override
    public String formatQuestion(char letter, String text) {
        return "\t" + letter + ")" + text;
    }
}
