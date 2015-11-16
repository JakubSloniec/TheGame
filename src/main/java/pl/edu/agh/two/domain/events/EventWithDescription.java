package pl.edu.agh.two.domain.events;

import java.util.Optional;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.GameConsoleNotSet;

public class EventWithDescription implements IEvent {
    private Optional<GameConsole> gameConsole = Optional.empty();
    
    private String eventDescription = "";

    public GameConsole getGameConsole() {
        return gameConsole.orElseThrow(GameConsoleNotSet::new);
    }

    public void setGameConsole(GameConsole gameConsole) {
        this.gameConsole = Optional.of(gameConsole);
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void execute(IPlayer player) {
        getGameConsole().display(getEventDescription());
    }
}
