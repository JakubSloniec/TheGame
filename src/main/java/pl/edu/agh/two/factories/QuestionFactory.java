package pl.edu.agh.two.factories;

import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.Question;

import java.util.Collection;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class QuestionFactory {

    public static Question createQuestion(String questionText, Collection<Answer> answers){
        return new Question(questionText,answers);
    }

    public static Answer createAnswer(String text, int points){
        return new Answer(text,points);
    }
}
