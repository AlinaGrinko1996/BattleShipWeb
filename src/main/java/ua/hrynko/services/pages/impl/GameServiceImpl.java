package ua.hrynko.services.pages.impl;

import ua.hrynko.BL.Cell;
import ua.hrynko.BL.Game;
import ua.hrynko.BL.Player;
import ua.hrynko.services.pages.GameService;

public class GameServiceImpl implements GameService {
    /**
     * Initialize game for two players
     * @param playerA name of first player
     * @param playerB name of second player
     * @return game object
     */
    @Override
    public Game initializeGameWithPlayers(String playerA, String playerB) {
        Game game = new Game();
        game.initialize(playerA, playerB);
        return game;
    }

    /**
     * Returns classes used in css to change cells appearance
     * @param cell input cell object
     * @param isDeskMain indicator of type of desk. Needed because cells of both players has same range of ids.
     * @return class string
     */
    @Override
    public String getClassForCell(Cell cell, boolean isDeskMain) {
        //classes can be moved to resources
        if (cell.isHit()) {
            if (cell.isBusy()) {
                return "ship-broken";
            } else {
                return "hit";
            }
        } else {
            if (cell.isBusy()) {
                return isDeskMain ? "selected" : "none";
            }
        }
        return "none";
    }

    /**
     * Pick up cell on main board to place ship there
     * In future there will be also check for ships amount, if it is allowed to put ship there and so on
     * @param cellId id of cell from client
     * @param game Game persistent object
     */
    @Override
    public void chooseCellOnMainBoard(int cellId, Game game) {
        Cell cellActive = game.getCurrentPlayer().getBoard().getCellById(cellId);
        cellActive.toggleBusy();
    }

    /**
     * Shoot at the opponent
     * there should be check if such action is allowed
     * @param cellId id of cell from client
     * @param game persistent game object
     * @return class of target cell (used in css)
     */
    @Override
    public String shootAtOpponent(int cellId, Game game) {
        Player targetPlayer = game.isPlayerACurrent() ? game.getPlayerB() : game.getPlayerA();
        Cell cellActive = targetPlayer.getBoard().getCellById(cellId);
        cellActive.setHit(true);
        return getClassForCell(cellActive, false);
    }
}
