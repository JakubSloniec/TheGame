package pl.edu.agh.two.domain.players.statistics;

import pl.edu.agh.two.domain.attributes.Attribute;

public interface IPlayerStatistic {

    public Attribute getAttribute();

    public Double getCurrentValue();

    public void add(Double value);

}
