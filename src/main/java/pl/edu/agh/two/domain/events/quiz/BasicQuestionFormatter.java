package pl.edu.agh.two.domain.events.quiz;

public class BasicQuestionFormatter implements IQuestionFormatter {
    @Override
    public String formatQuestion(char letter, String text) {
        return "\t" + letter + ")" + text;
    }
}
