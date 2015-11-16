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

    public static <T extends Number> Set<IPlayerStatistic<T>> createDefaultPlayerStatistics() {
        return new HashSet<IPlayerStatistic<T>>() {{
            add(createPlayerStatistic(ApplicationConstants.AVERAGE));
            add(createPlayerStatistic(ApplicationConstants.YEAR_OF_STUDY));
            add(createPlayerStatistic(ApplicationConstants.SEMESTER_OF_STUDY));
        }};
    }

    public static <T extends Number> IPlayerStatistic<T> createPlayerStatistic(String name) {
        return SimplePlayerStatistic.createPlayerStatistic(Attribute.createAttribute(name));
    }

    public static <T extends Number> IPlayerStatistic<T> createPlayerStatistic(String name, T initialValue) {
        return SimplePlayerStatistic.createPlayerStatisticWithInitialValue(Attribute.createAttribute(name), initialValue);
    }

}
