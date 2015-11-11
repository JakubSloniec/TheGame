package pl.edu.agh.two.theGame.model.rooms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.agh.edu.two.theGame.console.GameConsole;
import pl.edu.agh.two.theGame.model.events.Event;
import pl.edu.agh.two.theGame.model.player.Player;

@RunWith(MockitoJUnitRunner.class)

public class BasicRoomTest {
    @Mock protected Player playerMock;

    @Test(expected = AdjectiveFieldDoesNotExists.class)
    public void missingField() throws AdjectiveFieldDoesNotExists {
        BasicRoom instance = getInstance();
        instance.addAdjectiveRoom(Direction.NORTH, mock(Room.class));
        instance.go(Direction.EAST, playerMock);
    }

    @Test
    public void availableDirection() {
        BasicRoom instance = getInstance();
        instance.addAdjectiveRoom(Direction.NORTH, mock(Room.class));
        final Collection<Direction> availableDirections = instance.getAvailableDirections();
        assertEquals(availableDirections, new HashSet<>(Collections.singletonList(Direction.NORTH)));
    }

    @Test
    public void availableDirections() {
        BasicRoom instance = getInstance();
        instance.addAdjectiveRoom(Direction.NORTH, mock(Room.class));
        instance.addAdjectiveRoom(Direction.SOUTH, mock(Room.class));
        instance.addAdjectiveRoom(Direction.EAST, mock(Room.class));
        final Collection<Direction> availableDirections = instance.getAvailableDirections();
        assertEquals(availableDirections, new HashSet<>(Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.EAST)));
    }

    @Test
    public void goNorth() throws AdjectiveFieldDoesNotExists {
        BasicRoom instance = getInstance();
        final Room northRoom = mock(Room.class);
        instance.addAdjectiveRoom(Direction.NORTH, northRoom);
        instance.addAdjectiveRoom(Direction.EAST, mock(Room.class));

        when(northRoom.tryEnter(eq(instance), any(Player.class))).thenReturn(true);
        assertEquals(northRoom, instance.go(Direction.NORTH, playerMock));
    }

    @Test
    public void goWestNotAllowed() throws AdjectiveFieldDoesNotExists {
        BasicRoom instance = getInstance();
        final Room westRoom = mock(Room.class);
        instance.addAdjectiveRoom(Direction.WEST, westRoom);
        instance.addAdjectiveRoom(Direction.EAST, mock(Room.class));

        when(westRoom.tryEnter(eq(instance), any(Player.class))).thenReturn(false);
        assertEquals(instance, instance.go(Direction.WEST, playerMock));
    }

    @Test
    public void tryEnter() throws Exception {
        BasicRoom instance = getInstance();
        String description = "Room test";
        instance.setHelloMessage(description);

        final GameConsole gameConsoleMock = mock(GameConsole.class);
        instance.setGameConsole(gameConsoleMock);
        instance.tryEnter(mock(Room.class), playerMock);
        verify(gameConsoleMock).display(description);

    }

    @Test
    public void executeEvent() {
        BasicRoom instance = getInstance();
        final Event eventMock = mock(Event.class);
        instance.setEvent(eventMock);
        instance.executeEvent(playerMock);

        verify(eventMock).execute(playerMock);

    }

    protected BasicRoom getInstance() {
        return new BasicRoom();
    }

}