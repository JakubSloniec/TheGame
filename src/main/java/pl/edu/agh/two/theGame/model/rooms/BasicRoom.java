package pl.edu.agh.two.theGame.model.rooms;

import java.util.Collection;
import java.util.Optional;

import pl.edu.agh.two.theGame.model.player.Player;

public class BasicRoom extends AbstractRoom {
    private String helloMessage;

    @Override
    public Room go(Direction direction, Player player) throws AdjectiveFieldDoesNotExists {
        final Room targetRoom = Optional.ofNullable(getAdjectiveRooms().get(direction))
                .orElseThrow(AdjectiveFieldDoesNotExists::new);

        if (targetRoom.tryEnter(this, player)) {
            return targetRoom;
        } else {
            return this;
        }
    }

    @Override
    public boolean tryEnter(Room previousRoom, Player player) {
        getGameConsole().display(getHelloMessage());
        return true;
    }

    @Override
    public void executeEvent(Player player) {
        getEvent().execute(player);
    }

    @Override
    public Collection<Direction> getAvailableDirections() {
        return getAdjectiveRooms().keySet();
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    protected String getHelloMessage() {
        return helloMessage;
    }
}
