package pl.edu.agh.two.domain.events.quiz;

import java.util.Collection;

public class Question {
    private final Collection<Answer> answers;
    private final String questionText;

    public Question(String questionText, Collection<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public String getQuestionText() {
        return questionText;
    }
    
    public int getMaxAnswerPoints() {
    	return answers.stream().map(a -> a.getPoints()).max(Integer::compareTo).get();
    }
    
}
