package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.items.Item;
import pl.edu.agh.two.domain.players.IPlayer;

public class ItemRequiredToEnterRoom extends BasicRoom {
    private final Item requiredItem;

    public ItemRequiredToEnterRoom(Item requiredItem) {
        this.requiredItem = requiredItem;
    }

    @Override
    public boolean tryEnter(Room previousRoom, IPlayer player) {
        super.tryEnter(previousRoom, player);
        return player.getItems().contains(requiredItem);
    }
}

