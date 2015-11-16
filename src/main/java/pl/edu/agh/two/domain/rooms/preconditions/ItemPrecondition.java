package pl.edu.agh.two.domain.rooms.preconditions;

import pl.edu.agh.two.domain.items.Item;
import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class ItemPrecondition implements IPrecondition {

    private final Item item;

    private ItemPrecondition(Item item) {
        this.item = item;
    }

    @Override
    public boolean test(IPlayer player) {
        return player.getBackpack().hasItem(item);
    }

    public static ItemPrecondition createPrecondition(Item item) {
        return new ItemPrecondition(item);
    }

}
