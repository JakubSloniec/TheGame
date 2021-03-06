package pl.edu.agh.two.parser.factories;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.fight.Enemy;
import pl.edu.agh.two.domain.events.quiz.fight.Fight;
import pl.edu.agh.two.domain.events.quiz.fight.FightAnswer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.domain.players.statistics.SimplePlayerStatistic;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.events.fights.RawAction;
import pl.edu.agh.two.parser.events.fights.RawAnswer;
import pl.edu.agh.two.parser.events.fights.RawEnemy;
import pl.edu.agh.two.parser.events.fights.RawFight;
import pl.edu.agh.two.parser.map.RawAttribute;
import pl.edu.agh.two.repositories.AttributesRepository;

/**
 * Created by oem on 2016-01-10.
 */
public class FightEventsFactory implements IEventsFactory {

    @Override
    public IEvent getEventFromFile(String eventFileName, GameConsole gameConsole) {
        ConfigReader<RawFight> configReader=new ConfigReader<>(RawFight.class);
        RawFight rawFight=configReader.readConfig(eventFileName);

        //get questions
        List<Question> questionList=new LinkedList<Question>();
        for(RawAction rawAction:rawFight.getActions()) {
            List<Answer> answerList=new LinkedList<Answer>();
            for(RawAnswer rawAnswer:rawAction.getAnswers()) {
                FightAnswer answer = new FightAnswer(rawAnswer.getAnswer(),rawAnswer.getPoints());
                answer.setResponse(rawAnswer.getReaction());
                answerList.add(answer);

            }
            questionList.add(new Question(rawAction.getQuestion(),answerList));
        }

        //enemy
        RawEnemy rawEnemy=rawFight.getEnemy();
        Set<IPlayerStatistic> statisticSet=new HashSet<IPlayerStatistic>();
        for(RawAttribute rawAttribute:rawEnemy.getAttributes()) {
            if(rawAttribute.getCreativity()>0) {
                statisticSet.add(new SimplePlayerStatistic(AttributesRepository.getAttribute("creativity"),new Integer(rawAttribute.getCreativity()).doubleValue()));
            }
            if(rawAttribute.getEnergia()>0) {
                statisticSet.add(new SimplePlayerStatistic(AttributesRepository.getAttribute("energia"),new Integer(rawAttribute.getCreativity()).doubleValue()));
            }
        }
        Enemy enemy=new Enemy(statisticSet,rawEnemy.getHP());

        //event map

        Fight fight=new Fight(questionList,enemy);
        fight.setGameConsole(gameConsole);
        fight.setEventDescription(rawFight.getIntroduction());


        return fight;
    }
}
