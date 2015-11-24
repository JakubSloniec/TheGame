package pl.edu.agh.two.domain.events.quiz;

public class BasicAnswerFormatter implements IAnswerFormatter {

    public static final char INITIAL_ANSWERS_ENUMERATION = 'a';

    @Override
    public String formatQuestion(int answerNumber, String text) {
        return "\t" + Character.toString((char) ('a' + answerNumber)) + ") " + text;
    }

    @Override
    public int inputTextToAnswerNumber(String userInput) {
        return userInput.charAt(0) - INITIAL_ANSWERS_ENUMERATION;
    }
}
