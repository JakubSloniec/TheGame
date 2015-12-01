package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

import java.util.List;
import java.util.Random;

public class RandomEvent extends EventWithDescription {
    private final Random random = new Random();

    private final List<IEvent> availableEvents;

    public RandomEvent(List<IEvent> availableEvents) {
        this.availableEvents = availableEvents;
    }

    @Override
    public void executeLogic(IPlayer player) {
        super.execute(player);
        availableEvents.get(random.nextInt(availableEvents.size()))
                .execute(player);
    }
}
