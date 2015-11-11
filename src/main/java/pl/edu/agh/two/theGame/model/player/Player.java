package pl.edu.agh.two.theGame.model.player;

import java.util.Collection;

import pl.edu.agh.two.theGame.model.items.Item;

public interface Player {
    Collection<Item> getItems();

    void addToInventory(Item item);

    <T> T getStatistic(PlayerStatistic<T> statistic);

    <T> void updateStatistic(PlayerStatistic<T> statistic, T newValue);

}
