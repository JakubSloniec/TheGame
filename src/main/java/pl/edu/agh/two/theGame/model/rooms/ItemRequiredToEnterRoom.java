package pl.edu.agh.two.theGame.model.rooms;

import pl.edu.agh.two.theGame.model.items.Item;
import pl.edu.agh.two.theGame.model.player.Player;

public class ItemRequiredToEnterRoom extends BasicRoom {
    private final Item requiredItem;

    public ItemRequiredToEnterRoom(Item requiredItem) {
        this.requiredItem = requiredItem;
    }

    @Override
    public boolean tryEnter(Room previousRoom, Player player) {
        super.tryEnter(previousRoom, player);
        return player.getItems().contains(requiredItem);
    }
}

