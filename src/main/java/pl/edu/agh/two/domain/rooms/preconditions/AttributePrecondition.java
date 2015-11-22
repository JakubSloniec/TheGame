package pl.edu.agh.two.domain.rooms.preconditions;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class AttributePrecondition implements IPrecondition {

    private final Attribute attribute;
    private final Double minimumValue;

    private AttributePrecondition(Attribute attribute, Double minimumValue) {
        this.minimumValue = minimumValue;
        this.attribute = attribute;
    }

    @Override
    public boolean test(IPlayer player) {
        IPlayerStatistic playerStatistic = player.getStatistic(attribute);
        return minimumValue.compareTo(playerStatistic.getCurrentValue()) <= 0;
    }

    public static AttributePrecondition createPrecondition(Attribute attribute, Double minimumValue) {
        return new AttributePrecondition(attribute, minimumValue);
    }

}
