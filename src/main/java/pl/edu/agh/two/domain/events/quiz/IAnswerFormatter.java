package pl.edu.agh.two.domain.events.quiz;

public interface IAnswerFormatter {
    String formatQuestion(int answerNumber, String text);

    int inputTextToAnswerNumber(String userInput);
}