package pl.edu.agh.two.domain.events.quiz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.UnmatchableAnswer;

public class Quiz extends EventWithDescription {
    private final List<Question> questions;
    private IAnswerFormatter answerFormtter = new BasicAnswerFormatter();
    protected Map<Set<Integer>, IEvent> pointsToEvents = new HashMap<>();

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public void executeLogic(IPlayer player) {
        executeQuiz(player);
    }

    protected int executeQuiz(IPlayer player) {
        int points = questions.stream().mapToInt(this::ask).sum();
        resultEvents(player,points);
        return points;
    }

    private int ask(Question question) {
        boolean answered = false;
        while(!answered) {
            getGameConsole().println(question.getQuestionText());
            Map<Integer, Answer> currentQuestionAnswers = new HashMap<>(question.getAnswers().size());
            int answerNumber = 0;
            for (Answer answer : question.getAnswers()) {
                getGameConsole().println(answerFormtter.formatQuestion(answerNumber, getAnswerText(answer)));
                currentQuestionAnswers.put(answerNumber, answer);
                answerNumber++;
            }
            final List<Answer> userAnswers = answerFormtter.readAnswer(getGameConsole()).stream()
                    .map(currentQuestionAnswers::get)
                    .filter(answer -> answer != null)
                    .collect(Collectors.toList());
            try {
                if (userAnswers.isEmpty()) {
                    throw new UnmatchableAnswer();
                }
                final boolean allUserAnswersCorrect = userAnswers.stream().map(Answer::getPoints).allMatch(points -> points > 0);
                int points = userAnswers.stream().mapToInt(Answer::getPoints).sum();

                if (allUserAnswersCorrect && points > 0) {
                    onCorrectAnswer();
                } else {
                    onIncorrectAnswer();
                }
                answered = true;
                return points;
            } catch(Exception e) {
                getGameConsole().println(e.getMessage());
            }
        }
        return 0;
    }

    protected void onIncorrectAnswer() {
        getGameConsole().println("Wrong!");
    }

    protected void onCorrectAnswer() {
        getGameConsole().println("Correct!");
    }

    protected String getAnswerText(Answer answer){
        return answer.getText();
    }

    protected int resultEvents(IPlayer player, int points){
        pointsToEvents.forEach((pointsSet, event) -> {
            if (pointsSet.contains(points)) {
                event.execute(player);
            }
        });
        return points;
    }

    public void setAnswerFormtter(IAnswerFormatter answerFormtter) {
        this.answerFormtter = answerFormtter;
    }

    /**
     * I recommend to use com.google.common.collect.RangeSet as keys.
     *
     * @param pointsToEvents
     */
    public void setPointsToEvents(Map<Set<Integer>, IEvent> pointsToEvents) {
        this.pointsToEvents = pointsToEvents;
    }

}
