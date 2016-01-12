package pl.edu.agh.two.domain.events.quiz;

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
    protected Map<Set<Integer>, IEvent> pointsToEvents = new HashMap<>();
    private IQuizFormatter quizFormatter = new BasicQuizFormatter();

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }
    
    public Quiz(List<Question> question, String introduction) {
        super(introduction);
    	this.questions = question;
    }

    @Override
    public void executeLogic(IPlayer player) {
    	super.executeLogic(player);
        int result = executeQuiz(player);
        int maxResult = questions.stream().map(question -> (Integer) question.getMaxAnswerPoints()).reduce((a,b) -> a+b).get();
        int grade = getGrade(result, maxResult);
        pointsToEvents.get(pointsToEvents.keySet().stream().filter(set -> set.contains(grade)).findFirst().get()).execute(player);
    }

	private int getGrade(int result, int maxResult) {
		int grade = result / maxResult * 5;
        if (grade == 1 || grade == 0) {
        	grade = 2;
        }
		return grade;
	}

    protected int executeQuiz(IPlayer player) {
        int points = questions.stream().mapToInt(this::ask).sum();
        resultEvents(player, points);
        return points;
    }

    private int ask(Question question) {
        while (true) {
            quizFormatter.printQuestion(question, getGameConsole());
            Map<Integer, Answer> currentQuestionAnswers = new HashMap<>(question.getAnswers().size());
            int answerNumber = 0;
            for (Answer answer : question.getAnswers()) {
                quizFormatter
                        .printAnswer(answerNumber, getAnswerText(answer), getGameConsole());//// TODO: 12/23/2015   replace getAnswerText(answer) with answer
                currentQuestionAnswers.put(answerNumber, answer);
                answerNumber++;
            }
            final List<Answer> userAnswers = quizFormatter.readAnswer(getGameConsole()).stream()
                    .map(currentQuestionAnswers::get)
                    .filter(answer -> answer != null)
                    .collect(Collectors.toList());

            if (!userAnswers.isEmpty()) {
                final boolean allUserAnswersCorrect = userAnswers.stream().map(Answer::getPoints).allMatch(points -> points > 0);
                int points = userAnswers.stream().mapToInt(Answer::getPoints).sum();

                if (allUserAnswersCorrect && points > 0) {
                    onCorrectAnswer();
                } else {
                    onIncorrectAnswer();
                }
                return points;
            } else {
                quizFormatter.printUnmachableAnswer(getGameConsole());
            }
        }
    }

    protected void onIncorrectAnswer() {
        getGameConsole().println("Wrong!");
    }

    protected void onCorrectAnswer() {
        getGameConsole().println("Correct!");
    }

    protected String getAnswerText(Answer answer) {
        return answer.getText();
    }

    protected int resultEvents(IPlayer player, int points) {
        pointsToEvents.forEach((pointsSet, event) -> {
            if (pointsSet.contains(points)) {
                event.execute(player);
            }
        });
        return points;
    }

    public void setQuizFormatter(IQuizFormatter quizFormatter) {
        this.quizFormatter = quizFormatter;
    }

    /**
     * I recommend to use com.google.common.collect.RangeSet as keys.
     *
     */
    public void setPointsToEvents(Map<Set<Integer>, IEvent> pointsToEvents) {
        this.pointsToEvents = pointsToEvents;
    }

}
