package pl.edu.agh.two.domain.map;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.rooms.Direction;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.exceptions.RoomDoesNotExistException;

import java.util.Optional;

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
            return nextRoom.get().tryEnter(player);
        }
        throw new RoomDoesNotExistException();
    }

}
