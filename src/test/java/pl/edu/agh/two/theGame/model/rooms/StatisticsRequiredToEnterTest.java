package pl.edu.agh.two.theGame.model.rooms;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.players.statistics.DefaultPlayerStatistic;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.domain.rooms.Room;
import pl.edu.agh.two.domain.rooms.StatisticsRequiredToEnter;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsRequiredToEnterTest extends BasicRoomTest {

    private final static IPlayerStatistic<Number> requiredStatistic = DefaultPlayerStatistic.BLOOD_ALCOHOL_CONTENT;
    private final double minAlcoholContent = 0.0004;
    @Mock
    private GameConsole gameConsole;
    private StatisticsRequiredToEnter instance;

    @Override
    protected StatisticsRequiredToEnter getInstance() {
        return new StatisticsRequiredToEnter<>(requiredStatistic, minAlcoholContent);
    }

    @Before
    public void setUp() throws Exception {
        instance = getInstance();
        instance.setGameConsole(gameConsole);
        when(playerMock.getStatistic(DefaultPlayerStatistic.BLOOD_ALCOHOL_CONTENT)).thenReturn(minAlcoholContent);
    }

    @Test
    public void testTryEnterSuccessfully() throws Exception {
        final IPlayer playerMock = mock(IPlayer.class);
        when(playerMock.getStatistic(requiredStatistic)).thenReturn(minAlcoholContent * 2);
        assertTrue(instance.tryEnter(mock(Room.class), playerMock));
    }

    @Test
    public void testTryEnterFail() throws Exception {
        final IPlayer playerMock = mock(IPlayer.class);
        when(playerMock.getStatistic(requiredStatistic)).thenReturn(minAlcoholContent / 2);
        assertFalse(instance.tryEnter(mock(Room.class), playerMock));
    }

}