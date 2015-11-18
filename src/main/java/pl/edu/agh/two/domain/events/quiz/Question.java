package pl.edu.agh.two.domain.events.quiz;

import java.util.Set;

public class Question {
    private final Set<Answer> answers;
    private final String questionText;

    public Question(String questionText, Set<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public String getQuestionText() {
        return questionText;
    }
}
