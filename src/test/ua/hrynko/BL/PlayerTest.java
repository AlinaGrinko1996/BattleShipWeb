package ua.hrynko.BL;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void accessorsTest() {
        Player player = new Player(0, "a");

        assertEquals("a", player.getName());
        assertNotNull(player.getBoard());
    }
}
