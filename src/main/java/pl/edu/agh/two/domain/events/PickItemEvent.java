package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.items.Item;
import pl.edu.agh.two.domain.players.IPlayer;

public class PickItemEvent  extends EventWithDescription{
    private final Item item;

    public PickItemEvent(Item item) {
        this.item = item;
    }

    @Override
    public void execute(IPlayer player) {
        super.execute(player);
        player.getBackpack().addItem(item);
    }

    @Override
    public String getEventDescription() {
        return "You found new item: " + item.getName();
    }

}
