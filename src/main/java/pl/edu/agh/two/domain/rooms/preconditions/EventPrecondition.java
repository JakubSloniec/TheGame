package pl.edu.agh.two.domain.rooms.preconditions;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class EventPrecondition implements IPrecondition {

    private final IEvent event;

    public EventPrecondition(IEvent event) {
        this.event = event;
    }

    public IEvent getEvent() {
        return event;
    }

    @Override
    public boolean test(IPlayer player) {
        //TODO: return execute(...) after IEvent interface being changed
        event.execute(player);
        return true;
    }

    public static EventPrecondition createPrecondition(IEvent event) {
        return new EventPrecondition(event);
    }

}
