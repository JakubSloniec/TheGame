package pl.edu.agh.two.parser.events.fights;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 12/1/2015.
 */
public class RawAction {
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
