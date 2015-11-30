package pl.edu.agh.two.domain.rooms.preconditions;

import java.util.List;

import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.Quiz;
import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by Mateusz Pszczolka on 11/24/2015.
 */
public class PreconditionQuiz extends Quiz implements IPrecondition{
    public final int requiredPointsToPass;

    public PreconditionQuiz(List<Question> questions, int requiredPointsToPass) {
        super(questions);
        this.requiredPointsToPass = requiredPointsToPass;
    }

    @Override
    public boolean test(IPlayer player) {
        return this.executeQuiz(player) >  requiredPointsToPass;
    }
}
