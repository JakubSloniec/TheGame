package pl.edu.agh.two.repositories;

import pl.edu.agh.two.domain.items.IItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ps_krzysztof on 2015-11-24.
 */
public class ItemsRepository {

    private static Map<String, IItem> items;

    static {
        items = new HashMap<>();
    }

    public static IItem getItem(String name) {
        return items.get(name);
    }

    private static void addItem(IItem item) {
        if(!items.containsKey(item.getName())) {
            items.put(item.getName(), item);
        }
    }

}
