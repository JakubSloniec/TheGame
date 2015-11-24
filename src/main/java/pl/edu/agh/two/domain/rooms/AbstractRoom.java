package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

import java.util.*;

public abstract class AbstractRoom implements IRoom {

    public static class Builder<T extends AbstractRoom> {

        private final T room;

        protected Builder(T room) {
            this.room = room;
        }

        public Builder<T> setPreconditions(List<IPrecondition> preconditions) {
            room.setPreconditions(preconditions);
            return this;
        }

        public Builder<T> setGameConsole(GameConsole gameConsole) {
            room.setGameConsole(Optional.ofNullable(gameConsole));
            return this;
        }

        public T build() {
            return room;
        }

    }

    private final Coordinates coordinates;
    private final EnumMap<Direction, IRoom> adjectiveRooms = new EnumMap<>(Direction.class);
    private List<IPrecondition> preconditions = Collections.emptyList();
    private Optional<GameConsole> gameConsole = Optional.empty();

    protected AbstractRoom(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public Map<Direction, IRoom> getAdjacentRooms() {
        return Collections.unmodifiableMap(adjectiveRooms);
    }

    @Override
    public List<IPrecondition> getPreconditions() {
        return Collections.unmodifiableList(preconditions);
    }

    public void setPreconditions(List<IPrecondition> preconditions) {
        this.preconditions = preconditions;
    }

    protected Optional<GameConsole> getGameConsole() {
        return gameConsole;
    }

    protected void setGameConsole(Optional<GameConsole> gameConsole) {
        this.gameConsole = gameConsole;
    }
}
