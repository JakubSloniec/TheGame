package pl.edu.agh.two.domain.players;

import pl.edu.agh.two.domain.items.Item;

import java.util.Map;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class Backpack {

    private Map<Item, Integer> items;

    public Backpack(Map<Item, Integer> items) {
        this.items = items;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void addItem(Item item) {
        int count = hasItem(item) ? items.get(item) : 0;
        items.put(item, count + 1);
    }

    public boolean hasItem(Item item) {
        return items.containsKey(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

}
