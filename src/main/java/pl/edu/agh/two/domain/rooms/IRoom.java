package pl.edu.agh.two.domain.rooms;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

public interface IRoom {

    Coordinates getCoordinates();

    Map<Direction, IRoom> getAdjacentRooms();

    List<IPrecondition> getPreconditions();

    void enterRoom(IPlayer player);

    void executeEvent(IPlayer player);

    default Optional<IRoom> getAdjacentRoom(Direction direction) {
        return Optional.ofNullable(getAdjacentRooms().get(direction));
    }

    void addAdjectiveRoom(Direction direction, IRoom room);
    /**
     * Try if player can enter this room. Can cause side effects like interaction with user.
     * @return true if enter success, false otherwise
     */
    default boolean tryEnter(IPlayer player) {
        if(getPreconditions().isEmpty()) {
            return true;
        }
        return getPreconditions().stream().allMatch(precondition -> precondition.test(player));
    }

}
