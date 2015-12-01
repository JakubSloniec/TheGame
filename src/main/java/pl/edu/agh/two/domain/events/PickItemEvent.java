package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.players.IPlayer;

public class PickItemEvent  extends EventWithDescription{

    private final IItem item;

    public PickItemEvent(IItem item) {
        this.item = item;
    }

    @Override
    public void executeLogic(IPlayer player) {
        super.execute(player);
        player.getBackpack().addItem(item);
    }

    @Override
    public String getEventDescription() {
        return "You found new item: " + item.getName();
    }

}
