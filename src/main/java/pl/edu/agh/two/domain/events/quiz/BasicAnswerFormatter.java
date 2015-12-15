package pl.edu.agh.two.domain.events.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import pl.edu.agh.two.console.GameConsole;

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

    @Override
    public List<Integer> readAnswer(GameConsole gameConsole) {
        final String userInput = gameConsole.readLine();
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .filter(answer -> !answer.equals(""))
                .map(this::inputTextToAnswerNumber)
                .collect(Collectors.toList());
    }

}
