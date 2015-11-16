package pl.edu.agh.two.domain.players;

import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Set;

public interface IPlayer {

    public String getName();

    public Backpack getBackpack();

    public Set<IPlayerStatistic> getStatistics();

    public <T extends Number> IPlayerStatistic<T> getStatistic(String name);

}
