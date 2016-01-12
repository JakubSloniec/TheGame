package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

public class EndEvent extends EventWithDescription {

    public EndEvent() {

    }

    @Override
    public void executeLogic(IPlayer player) {
    }

    @Override
    public String getEventDescription() {

        return null;
    }

}
