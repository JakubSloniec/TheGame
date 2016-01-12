package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;

public class EventRoom extends AbstractRoom {

    private final IEvent event;

    private EventRoom(IEvent event, Coordinates coordinates) {
        super(coordinates);
        this.event = event;
    }

    @Override
    public void enterRoom(IPlayer player) {
        //TODO: if sth should happen (for example some message)
    }

    @Override
    public void executeEvent(IPlayer player) {
        event.execute(player);
    }

    public IEvent getEvent() {
        return event;
    }

    public static class Builder extends AbstractRoom.Builder<EventRoom> {

        public Builder(IEvent event, Coordinates coordinates) {
            super(new EventRoom(event, coordinates));
        }

    }

}
