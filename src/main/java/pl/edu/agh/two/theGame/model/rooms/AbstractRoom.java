package pl.edu.agh.two.theGame.model.rooms;

import java.util.EnumMap;
import java.util.Optional;

import pl.agh.edu.two.theGame.console.GameConsole;
import pl.edu.agh.two.theGame.model.GameConsoleNotSet;
import pl.edu.agh.two.theGame.model.events.Event;

public abstract class AbstractRoom implements Room {
    private final EnumMap<Direction, Room> adjectiveRooms = new EnumMap<>(Direction.class);
    private Optional<GameConsole> gameConsole = Optional.empty();
    private Event event;


    public void addAdjectiveRoom(Direction direction, Room room) {
        adjectiveRooms.put(direction, room);
    }

    protected GameConsole getGameConsole() {
        return gameConsole.orElseThrow(GameConsoleNotSet::new);
    }

    public void setGameConsole(GameConsole gameConsole) {
        this.gameConsole = Optional.of(gameConsole);
    }

    protected Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    protected EnumMap<Direction, Room> getAdjectiveRooms() {
        return adjectiveRooms;
    }
}
