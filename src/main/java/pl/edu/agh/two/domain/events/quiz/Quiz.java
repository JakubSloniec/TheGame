package pl.edu.agh.two.domain.events.quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

public class Quiz extends EventWithDescription implements IPrecondition {
    private final List<Question> questions;
    private final IAnswerFormatter questionFormatter;
    private final Optional<IEvent> onFail;
    private final Optional<IEvent> onSuccess;
    private int correctAnswers;
    private int requiredCorrectAnswers;
    private boolean quizPassed;

    public Quiz(List<Question> questions, IAnswerFormatter questionFormatter, int requiredCorrectAnswers, Optional<IEvent> onSuccess, Optional<IEvent> onFail) {
        this.questions = questions;
        this.questionFormatter = questionFormatter;
        this.onSuccess = onSuccess;
        this.onFail = onFail;
        this.requiredCorrectAnswers = requiredCorrectAnswers;
    }

    public Quiz(List<Question> questions, int requiredCorrectAnswers, Optional<IEvent> onSuccess, Optional<IEvent> onFail) {
        this(questions, new BasicAnswerFormatter(), requiredCorrectAnswers, onSuccess, onFail);
    }

    public Quiz(List<Question> questions, int requiredCorrectAnswers) {
        this(questions, new BasicAnswerFormatter(), requiredCorrectAnswers, Optional.empty(), Optional.empty());
    }

    @Override
    public void execute(IPlayer player) {
        correctAnswers = 0;
        questions.forEach(this::takeQuestion);
        quizPassed = correctAnswers >= requiredCorrectAnswers;
        (quizPassed ? onSuccess : onFail).ifPresent(event -> event.execute(player));
    }

    private void takeQuestion(Question question) {
        getGameConsole().println(question.getQuestionText());
        Map<Character, Answer> currentQuestionAnswers = new HashMap<>(question.getAnswers().size());
        char nextChar = 'a';
        for (Answer answer : question.getAnswers()) {
            getGameConsole().println(questionFormatter.formatQuestion(nextChar, answer.getText()));
            currentQuestionAnswers.put(nextChar, answer);
            nextChar++;
        }
        final String userInput = getGameConsole().readLine();
        final List<Answer> userAnswers = Arrays.stream(userInput.split(","))
                .map(String::trim)
                .map(answer -> answer.charAt(0))
                .map(currentQuestionAnswers::get)
                .collect(Collectors.toList());

        final boolean allUserAnswersCorrect = userAnswers.stream().allMatch(Answer::isCorrect);
        final boolean allCorrectAnswersTyped = question.getAnswers().stream().filter(Answer::isCorrect).allMatch(userAnswers::contains);

        if (allCorrectAnswersTyped && allUserAnswersCorrect) {
            onCorrectAnswer();
        } else {
            onIncorrectAnswer();
        }
    }

    protected void onIncorrectAnswer() {
        getGameConsole().println("Wrong!");
    }

    protected void onCorrectAnswer() {
        correctAnswers++;
        getGameConsole().println("Correct!");
    }

    @Override
    public boolean test(IPlayer player) {
        this.execute(player);
        return quizPassed;
    }
}
