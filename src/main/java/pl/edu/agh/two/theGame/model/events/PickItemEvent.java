package pl.edu.agh.two.theGame.model.events;

import pl.edu.agh.two.theGame.model.items.Item;
import pl.edu.agh.two.theGame.model.player.Player;

public class PickItemEvent  extends EventWithDescription{
    private final Item item;

    public PickItemEvent(Item item) {
        this.item = item;
    }

    @Override
    public void execute(Player player) {
        super.execute(player);
        player.addToInventory(item);
    }

    @Override
    public String getEventDescription() {
        return "You found new item: " + item.getName();
    }
}
