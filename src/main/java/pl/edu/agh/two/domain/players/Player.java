package pl.edu.agh.two.domain.players;

import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Collections;
import java.util.Set;

public class Player implements IPlayer {

    private final String name;
    private final Backpack backpack;
    private final Set<IPlayerStatistic> statistics;

    public Player(String name, Backpack backpack, Set<IPlayerStatistic> statistics) {
        this.name = name;
        this.backpack = backpack;
        this.statistics = statistics;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Backpack getBackpack() {
        return backpack;
    }

    @Override
    public Set<IPlayerStatistic> getStatistics() {
        return Collections.unmodifiableSet(statistics);
    }

    @Override
    public <T extends Number> IPlayerStatistic<T> getStatistic(String name) {
        return null;
    }

}
