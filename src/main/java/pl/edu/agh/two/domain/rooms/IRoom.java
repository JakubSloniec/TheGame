package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IRoom {

    public Map<Direction, IRoom> getAdjacentRooms();

    public List<IPrecondition> getPreconditions();

    public void enterRoom(IPlayer player);

    public void executeEvent(IPlayer player);

    public default Optional<IRoom> getAdjacentRoom(Direction direction) {
        return Optional.ofNullable(getAdjacentRooms().get(direction));
    }

    /**
     * Try if player can enter this room. Can cause side effects like interaction with user.
     * @return true if enter success, false otherwise
     */
    public default boolean tryEnter(IPlayer player) {
        if(getPreconditions().isEmpty()) {
            return true;
        }
        return getPreconditions().stream().allMatch(precondition -> precondition.test(player));
    }

}
