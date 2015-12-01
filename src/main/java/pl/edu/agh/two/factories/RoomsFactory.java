package pl.edu.agh.two.factories;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.rooms.Coordinates;
import pl.edu.agh.two.domain.rooms.EmptyRoom;
import pl.edu.agh.two.domain.rooms.EventRoom;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.domain.rooms.Wall;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class RoomsFactory {

    public static IRoom createEmptyRoom(IEvent event, int x, int y, Optional<List<IPrecondition>> preconditionsOptional, Optional<GameConsole> gameConsoleOptional) {
        EmptyRoom.Builder eventRoomBuilder = new EmptyRoom.Builder(new Coordinates(x, y));
        setValueIfOptionalPresent(preconditionsOptional, eventRoomBuilder::setPreconditions);
        setValueIfOptionalPresent(gameConsoleOptional, eventRoomBuilder::setGameConsole);
        return eventRoomBuilder.build();
    }

    public static IRoom createEventRoom(IEvent event, int x, int y, Optional<List<IPrecondition>> preconditionsOptional, Optional<GameConsole> gameConsoleOptional) {
        EventRoom.Builder eventRoomBuilder = new EventRoom.Builder(event, new Coordinates(x, y));
        setValueIfOptionalPresent(preconditionsOptional, eventRoomBuilder::setPreconditions);
        setValueIfOptionalPresent(gameConsoleOptional, eventRoomBuilder::setGameConsole);
        return eventRoomBuilder.build();
    }

    public static IRoom createWall(int x, int y) {
        return new Wall(new Coordinates(x, y));
    }

    private static <T> void setValueIfOptionalPresent(Optional<T> optional, Consumer<T> setterMethod) {
        if(optional.isPresent()) {
            setterMethod.accept(optional.get());
        }
    }


}
