package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

import java.util.List;

/**
 * Execute events in sequence
 */
public class MultipleEvents extends EventWithDescription {

    private final List<Event> subEvents;

    public MultipleEvents(List<Event> subEvents) {
        this.subEvents = subEvents;
    }

    public void execute(IPlayer player) {
        super.execute(player);
        for (Event subEvent : subEvents) {
            subEvent.execute(player);
        }
    }
}
