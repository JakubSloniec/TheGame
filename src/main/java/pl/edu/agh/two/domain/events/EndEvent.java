package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.GameConsoleNotSet;

public class EndEvent extends EventWithDescription {

    private final EventWithDescription previousEvent;

    public EndEvent(EventWithDescription previousEvent) {
        this.previousEvent = previousEvent;
    }

    @Override
    public void executeLogic(IPlayer player) {
        super.executeLogic(player);
        getGameConsole().winGame();
    }

    @Override
    public String getEventDescription() {
        return "";
    }

    @Override
    public GameConsole getGameConsole() {
        try {
            return super.getGameConsole();
        } catch (GameConsoleNotSet gameConsoleNotSet) {
            return previousEvent.getGameConsole();
        }
    }
}
