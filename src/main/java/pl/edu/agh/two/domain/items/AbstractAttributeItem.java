package pl.edu.agh.two.domain.items;

import java.util.Collections;
import java.util.Set;

import pl.edu.agh.two.domain.attributes.ItemAttribute;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.ContextRequireException;
import pl.edu.agh.two.exceptions.ItemNotInBackpackException;

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
    public void use(IPlayer player) throws ItemNotInBackpackException, ContextRequireException {
        player.getBackpack().removeItem(this);
        this.getAttributes().forEach((itemAttribute) -> {
            player.getStatistic(itemAttribute.getAttribute()).add(itemAttribute.getChangeValue());
        });
    }
}
