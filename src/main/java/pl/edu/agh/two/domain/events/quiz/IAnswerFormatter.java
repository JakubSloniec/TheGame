package pl.edu.agh.two.domain.events.quiz;

public interface IAnswerFormatter {
    String formatQuestion(char letter, String text);
}
