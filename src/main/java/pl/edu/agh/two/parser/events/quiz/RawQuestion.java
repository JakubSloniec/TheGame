package pl.edu.agh.two.parser.events.quiz;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawQuestion {
    private String question;
    private List<RawAnswer> answers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<RawAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<RawAnswer> answers) {
        this.answers = answers;
    }
}
