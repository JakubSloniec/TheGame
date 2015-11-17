package pl.edu.agh.two.domain.rooms.preconditions;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class AttributePrecondition<T extends Number & Comparable> implements IPrecondition {

    private final Attribute<T> attribute;
    private final T minimumValue;

    private AttributePrecondition(Attribute<T> attribute, T minimumValue) {
        this.minimumValue = minimumValue;
        this.attribute = attribute;
    }

    @Override
    public boolean test(IPlayer player) {
        IPlayerStatistic<T> playerStatistic = player.getStatistic(attribute);
        return minimumValue.compareTo(playerStatistic.getCurrentValue()) <= 0;
    }

    public static <T extends Number & Comparable> AttributePrecondition<T> createPrecondition(Attribute<T> attribute, T minimumValue) {
        return new AttributePrecondition(attribute, minimumValue);
    }


}
