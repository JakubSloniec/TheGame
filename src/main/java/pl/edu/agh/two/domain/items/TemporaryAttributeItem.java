package pl.edu.agh.two.domain.items;

import pl.edu.agh.two.domain.attributes.ItemAttribute;

import java.util.Set;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class TemporaryAttributeItem extends AbstractAttributeItem {

    public static class Builder extends AbstractItem.Builder<TemporaryAttributeItem> {

        protected Builder(String name, Set<ItemAttribute> attributes) {
            super(new TemporaryAttributeItem(name, attributes));
        }

    }

    protected TemporaryAttributeItem(String name, Set<ItemAttribute> attributes) {
        super(name, attributes);
    }

}
