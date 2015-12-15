package pl.edu.agh.two.domain.events.quiz;

import java.util.List;

import pl.edu.agh.two.console.GameConsole;

public interface IAnswerFormatter {
    String formatQuestion(int answerNumber, String text);

    int inputTextToAnswerNumber(String userInput);

    List<Integer> readAnswer(GameConsole gameConsole);
}