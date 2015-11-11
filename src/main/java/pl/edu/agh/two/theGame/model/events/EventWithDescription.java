package pl.edu.agh.two.theGame.model.events;

import java.util.Optional;

import pl.agh.edu.two.theGame.console.GameConsole;
import pl.edu.agh.two.theGame.model.GameConsoleNotSet;
import pl.edu.agh.two.theGame.model.player.Player;

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

    public void execute(Player player) {
        getGameConsole().display(getEventDescription());
    }
}
