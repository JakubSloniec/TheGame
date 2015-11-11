package pl.edu.agh.two.theGame.model.events;

import java.util.List;
import java.util.Random;

import pl.edu.agh.two.theGame.model.player.Player;

public class RandomEvent extends EventWithDescription {
    private final Random random = new Random();

    private final List<Event> availableEvents;

    public RandomEvent(List<Event> availableEvents) {
        this.availableEvents = availableEvents;
    }

    @Override
    public void execute(Player player) {
        super.execute(player);
        availableEvents.get(random.nextInt(availableEvents.size()))
                .execute(player);
    }
}
