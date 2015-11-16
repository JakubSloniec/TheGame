package pl.edu.agh.two.domain.players.statistics;

import pl.edu.agh.two.domain.attributes.Attribute;

public interface IPlayerStatistic<T extends Number> {

    public Attribute<T> getAttribute();

    public T getCurrentValue();

    public void add(T value);

}
