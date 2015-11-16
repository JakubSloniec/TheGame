package pl.edu.agh.two.factories;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.domain.players.statistics.SimplePlayerStatistic;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class PlayerStatisticsFactory {

    public static <T extends Number> IPlayerStatistic<T> createPlayerStatistic(String name) {
        return SimplePlayerStatistic.createPlayerStatistic(Attribute.createAttribute(name));
    }

    public static <T extends Number> IPlayerStatistic<T> createPlayerStatistic(String name, T initialValue) {
        return SimplePlayerStatistic.createPlayerStatisticWithInitialValue(Attribute.createAttribute(name), initialValue);
    }

}
