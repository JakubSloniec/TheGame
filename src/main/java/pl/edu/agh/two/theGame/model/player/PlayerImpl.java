package pl.edu.agh.two.theGame.model.player;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import pl.edu.agh.two.theGame.model.items.Item;

public class PlayerImpl implements Player {
    private final Set<Item> items = new LinkedHashSet<>();
    private final Map<PlayerStatistic, Object> playerStatistics = new HashMap<>();

    @Override
    public Collection<Item> getItems() {
        return new CopyOnWriteArraySet<>(items);
    }

    @Override
    public void addToInventory(Item item) {
        items.add(item);

    }

    @Override
    public <T> T getStatistic(PlayerStatistic<T> statistic) {
        @SuppressWarnings("unchecked") //we put only T type values into map for PlayerStatistic<T>
        final T value = (T) playerStatistics.computeIfAbsent(statistic, PlayerStatistic::initialValue);
        return value;
    }

    @Override
    public <T> void updateStatistic(PlayerStatistic<T> statistic, T newValue) {
        playerStatistics.put(statistic, newValue);
    }
}
