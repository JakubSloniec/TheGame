package pl.edu.agh.two.domain.rooms;

import java.util.Collection;
import java.util.Optional;

import pl.edu.agh.two.domain.players.IPlayer;

public class BasicRoom extends AbstractRoom {
    private String helloMessage;

    @Override
    public Room go(Direction direction, IPlayer player) throws AdjectiveFieldDoesNotExists {
        final Room targetRoom = Optional.ofNullable(getAdjectiveRooms().get(direction))
                .orElseThrow(AdjectiveFieldDoesNotExists::new);

        if (targetRoom.tryEnter(this, player)) {
            return targetRoom;
        } else {
            return this;
        }
    }

    @Override
    public boolean tryEnter(Room previousRoom, IPlayer player) {
        getGameConsole().display(getHelloMessage());
        return true;
    }

    @Override
    public void executeEvent(IPlayer player) {
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
