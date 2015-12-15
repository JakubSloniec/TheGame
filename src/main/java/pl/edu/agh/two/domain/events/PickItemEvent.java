package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.players.IPlayer;

public class PickItemEvent  extends EventWithDescription{

    private final IItem item;

    public PickItemEvent(IItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        this.item = item;
    }

    @Override
    public void executeLogic(IPlayer player) {
        super.executeLogic(player);
        player.getBackpack().addItem(item);
    }

    @Override
    public String getEventDescription() {
        return "You found new item: " + item.getName();
    }

}
