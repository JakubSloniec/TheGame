package pl.edu.agh.two.domain.events;

import java.util.Optional;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.GameConsoleNotSet;

public class EventWithDescription implements IEvent
    private boolean finished = false;
    private Optional<GameConsole> gameConsole = Optional.empty();
    private String eventDescription = "";

    public EventWithDescription() {
    }

    public EventWithDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

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

    protected void executeLogic(IPlayer player) {
        getGameConsole().display(getEventDescription());
    }

    protected void cleanUp() {
        finished = true;
    }

    @Override
    public void execute(IPlayer player) {
        if (!finished) {
            executeLogic(player);
            cleanUp();
        }
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
