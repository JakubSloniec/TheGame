package pl.edu.agh.two.domain.attributes;

import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class AttributeHelper {

    public static IPlayerStatistic getStatisticForAttribute(Collection<IPlayerStatistic> statistics, Attribute attribute){
        if(statistics == null || attribute == null){
            return null;
        }
        return statistics.stream().filter(statistic -> attribute.equals(statistic.getAttribute())).findFirst().get();
    }
}
