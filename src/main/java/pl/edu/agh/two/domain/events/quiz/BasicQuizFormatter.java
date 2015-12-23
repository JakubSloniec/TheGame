package pl.edu.agh.two.domain.events.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.edu.agh.two.console.GameConsole;

public class BasicQuizFormatter implements IQuizFormatter {

    public static final char INITIAL_ANSWERS_ENUMERATION = 'a';

    public String formatAnswer(int answerNumber, String text) {
        return "\t" + Character.toString((char) ('a' + answerNumber)) + ") " + text;
    }

    @Override
    public void printAnswer(int answerNumber, Answer answer, GameConsole gameConsole) {
        printAnswer(answerNumber, answer.getText(), gameConsole);
    }

    @Override
    public void printAnswer(int answerNumber, String answer, GameConsole gameConsole) {
        gameConsole.println(formatAnswer(answerNumber, answer));
    }

    @Override
    public void printQuestion(Question question, GameConsole gameConsole) {
        gameConsole.println(question.getQuestionText());
    }

    @Override
    public int inputTextToAnswerNumber(String userInput) {
        return userInput.charAt(0) - INITIAL_ANSWERS_ENUMERATION;
    }

    @Override
    public List<Integer> readAnswer(GameConsole gameConsole) {
        final String userInput = gameConsole.readLine();
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .filter(answer -> !answer.equals(""))
                .map(this::inputTextToAnswerNumber)
                .collect(Collectors.toList());
    }

    @Override
    public void printUnmachableAnswer(GameConsole gameConsole) {
        gameConsole.println("Unmatchable answer.");
    }

}
