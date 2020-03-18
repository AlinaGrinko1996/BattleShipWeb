package ua.hrynko.BL;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void gameAccessorsTest() {
        Game game = new Game();

        assertNull(game.getPlayerA());
        assertNull(game.getPlayerB());

        game.initialize("", "");

        assertNotNull(game.getPlayerA());
        assertNotNull(game.getPlayerB());

        game.setPlayerACurrent(true);
        assertEquals(game.getPlayerA(), game.getCurrentPlayer());
    }
}
