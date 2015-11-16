package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

import java.util.*;

public abstract class AbstractRoom implements IRoom {

    public static class Builder<T extends AbstractRoom> {

        private final T room;

        public Builder(T room) {
            this.room = room;
        }

        public Builder<T> setPreconditions(Set<IPrecondition> preconditions) {
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

    private final EnumMap<Direction, IRoom> adjectiveRooms = new EnumMap<>(Direction.class);
    private Set<IPrecondition> preconditions = Collections.emptySet();
    private Optional<GameConsole> gameConsole = Optional.empty();

    protected AbstractRoom() {
    }

    @Override
    public Map<Direction, IRoom> getAdjacentRooms() {
        return Collections.unmodifiableMap(adjectiveRooms);
    }

    @Override
    public Set<IPrecondition> getPreconditions() {
        return Collections.unmodifiableSet(preconditions);
    }

    public void setPreconditions(Set<IPrecondition> preconditions) {
        this.preconditions = preconditions;
    }

    protected Optional<GameConsole> getGameConsole() {
        return gameConsole;
    }

    protected void setGameConsole(Optional<GameConsole> gameConsole) {
        this.gameConsole = gameConsole;
    }
}
