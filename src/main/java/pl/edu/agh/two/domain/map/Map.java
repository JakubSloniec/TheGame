package pl.edu.agh.two.domain.map;

import java.util.Optional;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.rooms.Direction;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.exceptions.RoomDoesNotExistException;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class Map {

    private final IRoom[][] map;
    private IRoom currentRoom;

    public Map(int mapSize) {
        this.map = new IRoom[mapSize][mapSize];
    }

    public IRoom[][] getMap() {
        return map;
    }

    public IRoom getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(IRoom currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addRoom(int x, int y, IRoom room) {
        map[x][y] = room;
    }

    public boolean go(Direction direction, IPlayer player) throws RoomDoesNotExistException {
        Optional<IRoom> nextRoom = getCurrentRoom().getAdjacentRoom(direction);
        if(nextRoom.isPresent()) {
            if (nextRoom.get().tryEnter(player)) {
                setCurrentRoom(nextRoom.get());
                return true;
            }
            return false;
        }
        throw new RoomDoesNotExistException();
    }

}
