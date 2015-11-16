package pl.edu.agh.two.factories;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.rooms.EventRoom;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.domain.rooms.MessageRoom;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class RoomsFactory {

    public static IRoom createRoom(IEvent event, Optional<Set<IPrecondition>> preconditionsOptional, Optional<GameConsole> gameConsoleOptional) {
        EventRoom.Builder eventRoomBuilder = new EventRoom.Builder(event);
        setValueIfOptionalPresent(preconditionsOptional, eventRoomBuilder::setPreconditions);
        setValueIfOptionalPresent(gameConsoleOptional, eventRoomBuilder::setGameConsole);
        return eventRoomBuilder.build();
    }

    public static IRoom createRoom(String message, Optional<Set<IPrecondition>> preconditionsOptional, Optional<GameConsole> gameConsoleOptional) {
        MessageRoom.Builder messageRoomBuilder = new MessageRoom.Builder(message);
        setValueIfOptionalPresent(preconditionsOptional, messageRoomBuilder::setPreconditions);
        setValueIfOptionalPresent(gameConsoleOptional, messageRoomBuilder::setGameConsole);
        return messageRoomBuilder.build();
    }

    private static <T> void setValueIfOptionalPresent(Optional<T> optional, Consumer<T> setterMethod) {
        if(optional.isPresent()) {
            setterMethod.accept(optional.get());
        }
    }


}
