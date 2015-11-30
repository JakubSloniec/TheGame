package pl.edu.agh.two.parser.events.quiz;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawQuiz {
    private String name;
    private String introduction;
    private List<RawQuestion> questions;
    private List<RawEndText> endTexts;

    public String getName() {return name;}

    public void setName(String name) {this.name=name;}

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<RawQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<RawQuestion> questions) {
        this.questions = questions;
    }

    public List<RawEndText> getEndTexts() {
        return endTexts;
    }

    public void setEndTexts(List<RawEndText> endTexts) {
        this.endTexts = endTexts;
    }
}
