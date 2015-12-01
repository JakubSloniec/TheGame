package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

import java.util.List;

/**
 * Execute events in sequence
 */
public class MultipleEvents extends EventWithDescription {

    private final List<IEvent> subEvents;

    public MultipleEvents(List<IEvent> subEvents) {
        this.subEvents = subEvents;
    }

    @Override
    public void executeLogic(IPlayer player) {
        super.execute(player);
        for (IEvent subEvent : subEvents) {
            subEvent.execute(player);
        }
    }
}
