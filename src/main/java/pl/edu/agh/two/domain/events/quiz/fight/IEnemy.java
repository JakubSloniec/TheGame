package pl.edu.agh.two.domain.events.quiz.fight;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Set;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public interface IEnemy {

    Double getStatistic(Attribute attribute);

    Set<IPlayerStatistic> getStatistics();

    public int getPower();

}
