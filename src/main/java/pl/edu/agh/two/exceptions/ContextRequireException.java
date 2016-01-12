package pl.edu.agh.two.exceptions;

import pl.edu.agh.two.domain.items.IItem;

public class ContextRequireException extends Exception {
    public ContextRequireException(IItem item) {
        super("Item " + item + " cannot be used without context");
    }
}
