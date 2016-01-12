package pl.edu.agh.two.domain.events.quiz.fight;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.events.quiz.Answer;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class FightAnswer extends Answer {

    private Attribute attribute = null;
    private int modifier = 0;
    private String response;

    public FightAnswer(String text, int points){
        super(text,points);
    }

    public FightAnswer(String text, int points, Attribute attribute){
        this(text, points);
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void updateModifier(int modifier){
        this.modifier = modifier;
    }

    @Override
    public int getPoints() {
        return Integer.max(super.getPoints()+modifier,0);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
