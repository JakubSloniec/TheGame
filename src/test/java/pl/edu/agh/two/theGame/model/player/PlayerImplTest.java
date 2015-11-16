package pl.edu.agh.two.theGame.model.player;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.two.domain.items.Item;
import pl.edu.agh.two.domain.players.statistics.DefaultPlayerStatistic;
import pl.edu.agh.two.domain.players.Player;

public class PlayerImplTest {

    private Player instance;

    @Before
    public void setUp() throws Exception {
        instance = new Player();

    }

    @Test
    public void testGetItems() throws Exception {
        instance.addToInventory(mock(Item.class));
        instance.addToInventory(mock(Item.class));
        final Collection<Item> items = instance.getItems();
        assertEquals(2, items.size());
    }

    @Test
    public void testGetDefaultStatistic() throws Exception {
        for (DefaultPlayerStatistic statistic : DefaultPlayerStatistic.values()) {
            assertEquals(statistic.initialValue(), instance.getStatistic(statistic));
        }
    }

    @Test
    public void testUpdateStatistic() throws Exception {
        instance.updateStatistic(DefaultPlayerStatistic.ETCS_POINTS, 52);
        assertEquals(52, instance.getStatistic(DefaultPlayerStatistic.ETCS_POINTS));
    }

    @Test
    public void testUpdateAlcoholStatistic() throws Exception {
        instance.updateStatistic(DefaultPlayerStatistic.BLOOD_ALCOHOL_CONTENT, 0.002);
        assertEquals(0.002, instance.getStatistic(DefaultPlayerStatistic.BLOOD_ALCOHOL_CONTENT));
    }
}