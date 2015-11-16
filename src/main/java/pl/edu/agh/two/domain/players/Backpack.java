package pl.edu.agh.two.domain.players;

import pl.edu.agh.two.domain.items.IItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class Backpack {

    private Map<IItem, Integer> items;

    private Backpack(Map<IItem, Integer> items) {
        this.items = items;
    }

    public Map<IItem, Integer> getItems() {
        return items;
    }

    public void addItem(IItem item) {
        incrementItemAmount(item);
    }

    public boolean hasItem(IItem item) {
        return items.containsKey(item);
    }

    public void removeItem(IItem item) {
        if(items.get(item) > 0) {
            decrementItemAmount(item);
        } else {
            items.remove(item);
        }
    }

    private void incrementItemAmount(IItem item) {
        changeItemAmount(item, 1);
    }

    private void decrementItemAmount(IItem item) {
        changeItemAmount(item, -1);
    }
    private void changeItemAmount(IItem item, int value) {
        int count = hasItem(item) ? items.get(item) : 0;
        items.put(item, count + value);
    }

    public static Backpack createBackpack() {
        return new Backpack(new HashMap<>());
    }



}
