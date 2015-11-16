package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.GameConsoleNotSet;

import java.util.Optional;

public class EventWithDescription implements Event {
    private Optional<GameConsole> gameConsole;
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
