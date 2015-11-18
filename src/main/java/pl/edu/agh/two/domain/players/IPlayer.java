package pl.edu.agh.two.domain.players;

import java.util.Set;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

public interface IPlayer{

    public String getName();

    public Backpack getBackpack();

    public Set<IPlayerStatistic> getStatistics();

    public <T extends Number> IPlayerStatistic<T> getStatistic(Attribute<T> attribute);

}
