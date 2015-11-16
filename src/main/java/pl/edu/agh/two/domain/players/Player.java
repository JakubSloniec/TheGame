package pl.edu.agh.two.domain.players;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.items.AbstractAttributeItem;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Collections;
import java.util.Set;

public class Player<T extends Number> implements IPlayer<T> {

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
    public void useItem(AbstractAttributeItem item) {
        if(getBackpack().hasItem(item)) {
            item.getAttributes().forEach((itemAttribute) -> {
                getStatistic(itemAttribute.getAttribute()).add(itemAttribute.getChangeValue());
            });
            getBackpack().removeItem(item);
        }
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
