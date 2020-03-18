package ua.hrynko.services.pages;

import ua.hrynko.BL.Cell;
import ua.hrynko.BL.Game;

public interface GameService {
    Game initializeGameWithPlayers(String playerA, String playerB);
    String getClassForCell(Cell cell, boolean isDeskMain);
    void chooseCellOnMainBoard(int cellId, Game game);
    String shootAtOpponent(int cellId, Game game);
}
