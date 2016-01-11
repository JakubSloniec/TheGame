package pl.edu.agh.two.domain.events.quiz;

import java.util.List;

import pl.edu.agh.two.console.GameConsole;

public interface IQuizFormatter {
    void printAnswer(int answerNumber, Answer answer, GameConsole gameConsole);

    void printAnswer(int answerNumber, String answer, GameConsole gameConsole);//TODO: remove this method from interface afeter fight refractoring

    void printQuestion(Question question, GameConsole gameConsole);

    int inputTextToAnswerNumber(String userInput);

    List<Integer> readAnswer(GameConsole gameConsole);

    void printUnmachableAnswer(GameConsole gameConsole);
}