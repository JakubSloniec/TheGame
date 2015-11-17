package pl.edu.agh.two.domain.rooms.preconditions;

import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class ItemPrecondition implements IPrecondition {

    private final IItem item;

    private ItemPrecondition(IItem item) {
        this.item = item;
    }

    @Override
    public boolean test(IPlayer player) {
        return player.getBackpack().hasItem(item);
    }

    public static ItemPrecondition createPrecondition(IItem item) {
        return new ItemPrecondition(item);
    }

}
