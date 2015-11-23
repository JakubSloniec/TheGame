package pl.edu.agh.two.exceptions;

import pl.edu.agh.two.domain.items.IItem;

/**
 * Created by Mateusz Pszczolka on 11/18/2015.
 */
public class ItemNotInBackpackException extends Exception {
    private final IItem item;

    public ItemNotInBackpackException(IItem item) {
        super("Item " + item.getName() + " not found in backpack");
        this.item = item;
    }
}
