package ua.hrynko.services;

import org.junit.Test;
import ua.hrynko.BL.Cell;
import ua.hrynko.BL.Game;
import ua.hrynko.BL.Player;
import ua.hrynko.services.pages.GameService;
import ua.hrynko.services.pages.impl.GameServiceImpl;

import static org.junit.Assert.*;

public class GameServiceTest {
    GameService gameService = new GameServiceImpl();

    @Test
    public void initializeGameTest() {
        String name1 = "aaa";
        String name2 = "bbb";

        Game game = gameService.initializeGameWithPlayers(name1, name2);

        assertNotNull(game);
        assertEquals(name1, game.getPlayerA().getName());
        assertEquals(name2, game.getPlayerB().getName());
    }

    @Test
    public void chooseCellTest() {
        Game game = gameService.initializeGameWithPlayers("", "");

        gameService.chooseCellOnMainBoard(0, game);

        Cell cell = game.getCurrentPlayer().getBoard().getCellById(0);
        assertTrue(cell.isBusy());

        gameService.chooseCellOnMainBoard(0, game);
        assertFalse(cell.isBusy());
    }

    @Test
    public void shootAtOpponent() {
        Game game = gameService.initializeGameWithPlayers("", "");

        gameService.shootAtOpponent(0, game);

        Player targetPlayer = game.isPlayerACurrent() ? game.getPlayerB() : game.getPlayerA();
        Cell cell = targetPlayer.getBoard().getCellById(0);
        assertTrue(cell.isHit());

        //not a toggle method
        gameService.shootAtOpponent(0, game);
        assertTrue(cell.isHit());

        //don't shoot ourselves in the foot
        cell = game.getCurrentPlayer().getBoard().getCellById(0);
        assertFalse(cell.isHit());
    }
}
