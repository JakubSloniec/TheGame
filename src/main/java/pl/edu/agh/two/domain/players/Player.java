package pl.edu.agh.two.domain.players;

import java.util.Collections;
import java.util.Set;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

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
    public <T extends Number> IPlayerStatistic<T> getStatistic(Attribute<T> attribute) {
        return null;
    }


}
