package pl.edu.agh.two.theGame.model.events;

import java.util.List;

import pl.edu.agh.two.theGame.model.player.Player;

/**
 * Execute events in sequence
 */
public class MultipleEvents extends EventWithDescription {

    private final List<Event> subEvents;

    public MultipleEvents(List<Event> subEvents) {
        this.subEvents = subEvents;
    }

    public void execute(Player player) {
        super.execute(player);
        for (Event subEvent : subEvents) {
            subEvent.execute(player);
        }
    }
}
