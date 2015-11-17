package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class EventRoom extends AbstractRoom {

    public static class Builder extends AbstractRoom.Builder<EventRoom> {

        public Builder(IEvent event) {
            super(new EventRoom(event));
        }

    }

    private final IEvent event;

    private EventRoom(IEvent event) {
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

}
