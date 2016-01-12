package pl.edu.agh.two.factories;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.edu.agh.two.configuration.ApplicationConstants;
import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.fight.Enemy;
import pl.edu.agh.two.domain.events.quiz.fight.Fight;
import pl.edu.agh.two.domain.events.quiz.fight.FightAnswer;
import pl.edu.agh.two.domain.events.quiz.fight.IEnemy;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.repositories.AttributesRepository;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class FightEventFactory {

    public static Fight createDefaultFight(){
        IEnemy enemy = createDefaultEnemey();
        List<Question> questionList = new LinkedList<>();
        List<Answer> answers = new LinkedList<>();
        answers.add(createFightAnswer("Try to talk yourself out", 1, AttributesRepository.getAttribute(ApplicationConstants.CREATIVITY)));
        answers.add(createFightAnswer("Try to flee", 2, AttributesRepository.getAttribute(ApplicationConstants.ENERGY)));

        Question combat = QuestionFactory.createQuestion("Give me some money!",answers);
        questionList.add(combat);

        return createFight(questionList,enemy);
    }

    public static Fight createFight(List<Question> questionList, IEnemy enemy){
        return new Fight(questionList,enemy);
    }

    public static IEnemy createEnemy(Set<IPlayerStatistic> statistics, int power){
        return new Enemy(statistics,power);
    }

    public static IEnemy createDefaultEnemey(){
        HashSet<IPlayerStatistic> enemyStatistics = new HashSet<>();
        enemyStatistics.add(PlayerStatisticsFactory.createPlayerStatistic(ApplicationConstants.CREATIVITY,1d));
        enemyStatistics.add(PlayerStatisticsFactory.createPlayerStatistic(ApplicationConstants.ENERGY,8d));

        return createEnemy(enemyStatistics, 2);
    }

    public static FightAnswer createFightAnswer(String text, int points, Attribute attribute){
        return new FightAnswer(text,points,attribute);
    }

    public static Map.Entry<Set<Integer>,IEvent> createReward(int min, int max, IEvent event){
        Set<Integer> points = new HashSet<>();
        for(;min<=max;min++){
            points.add(min);
        }
        return new AbstractMap.SimpleEntry<Set<Integer>, IEvent>(points,event);
    }
}
