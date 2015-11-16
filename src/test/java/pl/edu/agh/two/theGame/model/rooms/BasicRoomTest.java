//package pl.edu.agh.two.theGame.model.rooms;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashSet;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import pl.edu.agh.two.console.GameConsole;
//import pl.edu.agh.two.domain.events.IEvent;
//import pl.edu.agh.two.domain.players.IPlayer;
//import pl.edu.agh.two.domain.rooms.IRoom;
//import pl.edu.agh.two.exceptions.AdjectiveFieldDoesNotExists;
//import pl.edu.agh.two.domain.rooms.BasicRoom;
//import pl.edu.agh.two.domain.rooms.Direction;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class BasicRoomTest {
//    @Mock protected IPlayer playerMock;
//
//    @Test(expected = AdjectiveFieldDoesNotExists.class)
//    public void missingField() throws AdjectiveFieldDoesNotExists {
//        BasicRoom instance = getInstance();
//        instance.addAdjectiveRoom(Direction.NORTH, mock(IRoom.class));
//        instance.go(Direction.EAST, playerMock);
//    }
//
//    @Test
//    public void availableDirection() {
//        BasicRoom instance = getInstance();
//        instance.addAdjectiveRoom(Direction.NORTH, mock(IRoom.class));
//        final Collection<Direction> availableDirections = instance.getAvailableDirections();
//        assertEquals(availableDirections, new HashSet<>(Collections.singletonList(Direction.NORTH)));
//    }
//
//    @Test
//    public void availableDirections() {
//        BasicRoom instance = getInstance();
//        instance.addAdjectiveRoom(Direction.NORTH, mock(IRoom.class));
//        instance.addAdjectiveRoom(Direction.SOUTH, mock(IRoom.class));
//        instance.addAdjectiveRoom(Direction.EAST, mock(IRoom.class));
//        final Collection<Direction> availableDirections = instance.getAvailableDirections();
//        assertEquals(availableDirections, new HashSet<>(Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.EAST)));
//    }
//
//    @Test
//    public void goNorth() throws AdjectiveFieldDoesNotExists {
//        BasicRoom instance = getInstance();
//        final IRoom northRoom = mock(IRoom.class);
//        instance.addAdjectiveRoom(Direction.NORTH, northRoom);
//        instance.addAdjectiveRoom(Direction.EAST, mock(IRoom.class));
//
//        when(northRoom.tryEnter(eq(instance), any(IPlayer.class))).thenReturn(true);
//        assertEquals(northRoom, instance.go(Direction.NORTH, playerMock));
//    }
//
//    @Test
//    public void goWestNotAllowed() throws AdjectiveFieldDoesNotExists {
//        BasicRoom instance = getInstance();
//        final IRoom westRoom = mock(IRoom.class);
//        instance.addAdjectiveRoom(Direction.WEST, westRoom);
//        instance.addAdjectiveRoom(Direction.EAST, mock(IRoom.class));
//
//        when(westRoom.tryEnter(eq(instance), any(IPlayer.class))).thenReturn(false);
//        assertEquals(instance, instance.go(Direction.WEST, playerMock));
//    }
//
//    @Test
//    public void tryEnter() throws Exception {
//        BasicRoom instance = getInstance();
//        String description = "Room test";
//        instance.setHelloMessage(description);
//
//        final GameConsole gameConsoleMock = mock(GameConsole.class);
//        instance.setGameConsole(gameConsoleMock);
//        instance.tryEnter(mock(IRoom.class), playerMock);
//        verify(gameConsoleMock).display(description);
//
//    }
//
//    @Test
//    public void executeEvent() {
//        BasicRoom instance = getInstance();
//        final IEvent eventMock = mock(IEvent.class);
//        instance.setEvent(eventMock);
//        instance.executeEvent(playerMock);
//
//        verify(eventMock).execute(playerMock);
//
//    }
//
//    protected BasicRoom getInstance() {
//        return new BasicRoom();
//    }
//
//}