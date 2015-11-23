package pl.edu.agh.two.domain.players.statistics;

import pl.edu.agh.two.domain.attributes.Attribute;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class SimplePlayerStatistic implements IPlayerStatistic {

    private final Attribute attribute;
    private Double currentValue;

    public SimplePlayerStatistic(Attribute attribute, Double currentValue) {
        this.attribute = attribute;
        this.currentValue = currentValue;
    }

    @Override
    public Attribute getAttribute() {
        return attribute;
    }

    @Override
    public Double getCurrentValue() {
        return currentValue;
    }

    @Override
    public void add(Double value) {
        currentValue+=value;
    }

    public static IPlayerStatistic createPlayerStatistic(Attribute attribute) {
        return new SimplePlayerStatistic(attribute, attribute.getInitialValue().get());
    }

    public static IPlayerStatistic createPlayerStatisticWithInitialValue(Attribute attribute, Double initialValue) {
        return new SimplePlayerStatistic(attribute, initialValue);
    }
}
