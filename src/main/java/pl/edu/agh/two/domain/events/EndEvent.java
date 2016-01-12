package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

public class EndEvent extends EventWithDescription {

    private final IEvent previousEvent;

    public EndEvent(IEvent previousEvent) {
        this.previousEvent = previousEvent;
    }

    @Override
    public void executeLogic(IPlayer player) {
        super.executeLogic(player);
        getGameConsole().endGame();
    }

    @Override
    public String getEventDescription() {
        return "";
    }

}
