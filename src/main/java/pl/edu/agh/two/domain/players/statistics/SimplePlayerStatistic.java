package pl.edu.agh.two.domain.players.statistics;

import pl.edu.agh.two.domain.attributes.Attribute;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class SimplePlayerStatistic<T extends Number> implements IPlayerStatistic<T> {

    private final Attribute<T> attribute;
    private T currentValue;

    public SimplePlayerStatistic(Attribute<T> attribute, T currentValue) {
        this.attribute = attribute;
        this.currentValue = currentValue;
    }

    @Override
    public Attribute<T> getAttribute() {
        return attribute;
    }

    @Override
    public T getCurrentValue() {
        return currentValue;
    }

    @Override
    public void add(T value) {
        //TODO: Think about number, how to convert this stat??
    }

    public static <T extends Number> IPlayerStatistic<T> createPlayerStatistic(Attribute<T> attribute) {
        return new SimplePlayerStatistic<>(attribute, attribute.getInitialValue().get());
    }

    public static <T extends Number> IPlayerStatistic<T> createPlayerStatisticWithInitialValue(Attribute<T> attribute, T initialValue) {
        return new SimplePlayerStatistic<>(attribute, initialValue);
    }
}
