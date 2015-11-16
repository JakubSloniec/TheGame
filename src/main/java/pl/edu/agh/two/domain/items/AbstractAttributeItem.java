package pl.edu.agh.two.domain.items;

import pl.edu.agh.two.domain.attributes.ItemAttribute;
import pl.edu.agh.two.domain.players.IPlayer;

import java.util.Collections;
import java.util.Set;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public abstract class AbstractAttributeItem extends AbstractItem {

    private final Set<ItemAttribute> attributes;

    protected AbstractAttributeItem(String name, Set<ItemAttribute> attributes) {
        super(name);
        this.attributes = attributes;
    }

    public Set<ItemAttribute> getAttributes() {
        return Collections.unmodifiableSet(attributes);
    }

    @Override
    public void use(IPlayer player) {
        player.useItem(this);
    }
}
