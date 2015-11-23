package pl.edu.agh.two.domain.items;

import java.util.Set;

import pl.edu.agh.two.domain.attributes.ItemAttribute;

public class PermanentAttributeItem extends AbstractAttributeItem {

    public static class Builder extends AbstractItem.Builder<PermanentAttributeItem> {

        protected Builder(String name, Set<ItemAttribute> attributes) {
            super(new PermanentAttributeItem(name, attributes));
        }

    }

    protected PermanentAttributeItem(String name, Set<ItemAttribute> attributes) {
        super(name, attributes);
    }

}
