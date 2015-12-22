package pl.edu.agh.two.domain.events.quiz.fight;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.attributes.AttributeHelper;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Set;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class Enemy implements IEnemy {

    Set<IPlayerStatistic> statistics;

    private final int power;

    public Enemy(Set<IPlayerStatistic> statistics, int power){
        this.statistics = statistics;
        this.power = power;
    }

    @Override
    public Double getStatistic(Attribute attribute) {
        IPlayerStatistic statistic = AttributeHelper.getStatisticForAttribute(statistics,attribute);
        return statistic == null ? 0 : statistic.getCurrentValue();
    }

    public Set<IPlayerStatistic> getStatistics() {
        return statistics;
    }

    public int getPower() {
        return power;
    }
}
