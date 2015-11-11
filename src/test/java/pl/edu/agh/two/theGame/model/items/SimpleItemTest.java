package pl.edu.agh.two.theGame.model.items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleItemTest {

    @Test
    public void testGetName() throws Exception {
        final SimpleItem instance = new SimpleItem(toString());
        assertEquals(toString(), instance.getName());
    }
}