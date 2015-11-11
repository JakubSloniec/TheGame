package pl.edu.agh.two.theGame.model.rooms;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.agh.edu.two.theGame.console.GameConsole;
import pl.edu.agh.two.theGame.model.items.Item;
import pl.edu.agh.two.theGame.model.player.Player;


@RunWith(MockitoJUnitRunner.class)
public class ItemRequiredToEnterRoomTest extends BasicRoomTest {

    @Mock
    private Item requiredItemMock;
    @Mock
    private GameConsole gameConsole;

    private ItemRequiredToEnterRoom instance;

    @Override
    protected ItemRequiredToEnterRoom getInstance() {
        return new ItemRequiredToEnterRoom(requiredItemMock);
    }

    @Before
    public void setUp() throws Exception {
        instance = getInstance();
        instance.setGameConsole(gameConsole);
    }

    @Test
    public void testTryEnterSuccessfully() throws Exception {
        final Player playerMock = mock(Player.class);
        when(playerMock.getItems()).thenReturn(Collections.singletonList(requiredItemMock));
        assertTrue(instance.tryEnter(mock(Room.class), playerMock));
    }

    @Test
    public void testTryEnterFailEmptyEquipment() throws Exception {
        final Player playerMock = mock(Player.class);
        when(playerMock.getItems()).thenReturn(Collections.emptyList());
        assertFalse(instance.tryEnter(mock(Room.class), playerMock));
    }

    @Test
    public void testTryEnterFail() throws Exception {
        final Player playerMock = mock(Player.class);
        when(playerMock.getItems()).thenReturn(Arrays.asList(mock(Item.class), mock(Item.class)));
        assertFalse(instance.tryEnter(mock(Room.class), playerMock));
    }
}