package pl.edu.agh.two.domain.events.quiz.fight;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.Quiz;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.List;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class Fight extends Quiz {

    IEnemy enemy;
    IPlayer player;

    public Fight(List<Question> questionList, IEnemy enemy) {
        super(questionList);
        this.enemy = enemy;
    }

    @Override
    protected int executeQuiz(IPlayer player) {
        this.player = player;
        return super.executeQuiz(player);
    }

    @Override
    protected String getAnswerText(Answer answer) {
        StringBuffer buffer = new StringBuffer(answer.getText()).append("\n");
        if (answer instanceof FightAnswer) {
            modifier((FightAnswer) answer, buffer);
        }
        return buffer.toString();
    }

    @Override
    public String getEventDescription() {
        StringBuffer buffer = new StringBuffer(super.getEventDescription());
        buffer.append("Enemie's power: ").append(enemy.getPower());
        if(!enemy.getStatistics().isEmpty())
            buffer.append("\nStats: ");
        for (IPlayerStatistic statistic : enemy.getStatistics()) {
            buffer.append("[").append(statistic.getAttribute().getName()).append(" ").append(statistic.getCurrentValue()).append("]; ");
        }
        return buffer.toString();
    }

    private void modifier(FightAnswer answer, StringBuffer buffer) {
        Attribute attribute = answer.getAttribute();
        if (attribute != null) {
            int modifier = (int) (player.getStatistic(attribute).getCurrentValue() - enemy.getStatistic(attribute));
            answer.updateModifier(modifier);
            String name = attribute.getName();
            buffer.append("Answer is based upon '").append(name).append("'\n");
            buffer.append("Achieved modifier equals: ").append(modifier).append("\n");
        }
    }

    @Override
    protected int resultEvents(IPlayer player, int damageDealt){
        final int finalEnemyPowerBalance = damageDealt - enemy.getPower();
        pointsToEvents.forEach((pointsSet, event) -> {
            if(pointsSet.stream().anyMatch(powerBalance -> powerBalance <= finalEnemyPowerBalance)){
                event.execute(player);
            }
        });
        return finalEnemyPowerBalance;
    }

    @Override
    protected void onIncorrectAnswer() {
        getGameConsole().println("Weak attack...");
    }

    @Override
    protected void onCorrectAnswer() {
        getGameConsole().println("Successful attack!");
    }
}
