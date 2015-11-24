package pl.edu.agh.two.domain.items;

import java.util.Set;

import pl.edu.agh.two.domain.attributes.ItemAttribute;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.ContextRequireException;
import pl.edu.agh.two.exceptions.ItemNotInBackpackException;

public class TemporaryAttributeItem extends AbstractAttributeItem {

    public static class Builder extends AbstractItem.Builder<TemporaryAttributeItem> {

        public Builder(String name, Set<ItemAttribute> attributes) {
            super(new TemporaryAttributeItem(name, attributes));
        }

    }

    protected TemporaryAttributeItem(String name, Set<ItemAttribute> attributes) {
        super(name, attributes);
    }

    @Override
    public void use(IPlayer player, IUsageContext usageContext) throws ItemNotInBackpackException, ContextRequireException {
        super.use(player);
        if (usageContext == null) {
            throw new ContextRequireException(this);
        }
        usageContext.registerOnFizishListener(() -> getAttributes()
                        .forEach(itemAttribute ->
                                        player.getStatistic(itemAttribute.getAttribute())
                                                .add(itemAttribute.getOpositeOfChangeValue())
                        )
        );
    }

    @Override
    public void use(IPlayer player) throws ContextRequireException {
        throw new ContextRequireException(this);
    }
}
