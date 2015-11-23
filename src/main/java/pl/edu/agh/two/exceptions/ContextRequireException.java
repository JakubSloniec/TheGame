package pl.edu.agh.two.exceptions;

import pl.edu.agh.two.domain.items.IItem;

/**
 * Created by Mateusz Pszczolka on 11/18/2015.
 */
public class ContextRequireException extends Throwable {
    public ContextRequireException(IItem item) {
        super("Item " + item + " cannot be used without context");
    }
}
