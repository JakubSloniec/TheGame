package pl.edu.agh.two.factories;

import pl.edu.agh.two.configuration.ApplicationConstants;
import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.domain.players.statistics.SimplePlayerStatistic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class PlayerStatisticsFactory {

    public static Set<IPlayerStatistic> createDefaultPlayerStatistics() {
        return new HashSet<IPlayerStatistic>() {{
            for (String statistic : ApplicationConstants.DEFAULT_STATISTICS) {
                add(createPlayerStatistic(statistic));
            }
        }};
    }

    public static IPlayerStatistic createPlayerStatistic(String name) {
        return SimplePlayerStatistic.createPlayerStatistic(Attribute.createAttribute(name));
    }

    public static IPlayerStatistic createPlayerStatistic(String name, Double initialValue) {
        return SimplePlayerStatistic.createPlayerStatisticWithInitialValue(Attribute.createAttribute(name), initialValue);
    }

}