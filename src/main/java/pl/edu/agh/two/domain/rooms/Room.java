package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;

import java.util.Collection;

public interface Room {
    /**
     * Try to enter to room on Direction from this room.
     *
     * @return Returns room in with player ends. If player is not allowed to enter room on the @direction from this, this is returned
     * @throws AdjectiveFieldDoesNotExists if field on specific direction does not exists
     */
    Room go(Direction direction, IPlayer player) throws AdjectiveFieldDoesNotExists;

    /**
     * Try if player can enter this room. Can cause side effects like interaction with user.
     * @return true if enter success, false otherwise
     */
    boolean tryEnter(Room previousRoom, IPlayer player);

    void executeEvent(IPlayer player);

    Collection<Direction> getAvailableDirections();

}
