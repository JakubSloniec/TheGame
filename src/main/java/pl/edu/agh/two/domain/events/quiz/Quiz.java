package pl.edu.agh.two.domain.events.quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;

public class Quiz extends EventWithDescription {
    private final List<Question> questions;
    private IAnswerFormatter questionFormatter = new BasicAnswerFormatter();
    private Map<Set<Integer>, IEvent> pointsToEvents = new HashMap<>();

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public void execute(IPlayer player) {
        executeQuiz(player);
    }

    protected int executeQuiz(IPlayer player) {
        int points = questions.stream().mapToInt(this::ask).sum();
        pointsToEvents.forEach((pointsSet, event) -> {
            if (pointsSet.contains(points)) {
                event.execute(player);
            }
        });
        return points;
    }

    private int ask(Question question) {
        getGameConsole().println(question.getQuestionText());
        Map<Integer, Answer> currentQuestionAnswers = new HashMap<>(question.getAnswers().size());
        int answerNumber = 0;
        for (Answer answer : question.getAnswers()) {
            getGameConsole().println(questionFormatter.formatQuestion(answerNumber, answer.getText()));
            currentQuestionAnswers.put(answerNumber, answer);
            answerNumber++;
        }
        final String userInput = getGameConsole().readLine();
        final List<Answer> userAnswers = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(questionFormatter::inputTextToAnswerNumber)
                .map(currentQuestionAnswers::get)
                .collect(Collectors.toList());

        final boolean allUserAnswersCorrect = userAnswers.stream().map(Answer::getPoints).allMatch(points -> points > 0);
        int points = userAnswers.stream().mapToInt(Answer::getPoints).sum();

        if (allUserAnswersCorrect && points > 0) {
            onCorrectAnswer();
            return points;
        } else {
            onIncorrectAnswer();
            return 0;
        }
    }

    protected void onIncorrectAnswer() {
        getGameConsole().println("Wrong!");
    }

    protected void onCorrectAnswer() {
        getGameConsole().println("Correct!");
    }

    public void setQuestionFormatter(IAnswerFormatter questionFormatter) {
        this.questionFormatter = questionFormatter;
    }

    public void setPointsToEvents(Map<Set<Integer>, IEvent> pointsToEvents) {
        this.pointsToEvents = pointsToEvents;
    }

}
