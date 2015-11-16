package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;
import pl.edu.agh.two.exceptions.AdjectiveFieldDoesNotExists;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface IRoom {

    public Map<Direction, IRoom> getAdjacentRooms();

    public Set<IPrecondition> getPreconditions();

    public void enterRoom(IPlayer player);

    public void executeEvent(IPlayer player);

    /**
     *
     * @return returns set of possible directions
     */
    public default Set<Direction> getAvailableDirections() {
        return getAdjacentRooms().keySet();
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

    /**
     * Try to enter to room on Direction from this room.
     *
     * @return Returns room in with player ends. If player is not allowed to enter room on the @direction from this, this is returned
     * @throws pl.edu.agh.two.exceptions.AdjectiveFieldDoesNotExists if field on specific direction does not exists
     */
    public default IRoom go(Direction direction, IPlayer player) throws AdjectiveFieldDoesNotExists {
        final IRoom targetRoom = Optional.ofNullable(getAdjacentRooms().get(direction)).orElseThrow(AdjectiveFieldDoesNotExists::new);
        return targetRoom.tryEnter(player) ? targetRoom : this;
    }

}
