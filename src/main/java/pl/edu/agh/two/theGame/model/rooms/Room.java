package pl.edu.agh.two.theGame.model.rooms;

import java.util.Collection;

import pl.edu.agh.two.theGame.model.player.Player;

public interface Room {
    /**
     * Try to enter to room on Direction from this room.
     *
     * @return Returns room in with player ends. If player is not allowed to enter room on the @direction from this, this is returned
     * @throws AdjectiveFieldDoesNotExists if field on specific direction does not exists
     */
    Room go(Direction direction, Player player) throws AdjectiveFieldDoesNotExists;

    /**
     * Try if player can enter this room. Can cause side effects like interaction with user.
     * @return true if enter success, false otherwise
     */
    boolean tryEnter(Room previousRoom, Player player);

    void executeEvent(Player player);

    Collection<Direction> getAvailableDirections();

}
