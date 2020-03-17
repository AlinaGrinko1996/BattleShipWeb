package ua.hrynko.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import ua.hrynko.BL.*;
import ua.hrynko.exceptions.WrongCoordinateException;
import ua.hrynko.wrappers.CellRow;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Start page of application BattleShip.
 */
@Import(module = {"app/game-page"})
public class GamePage {
    private static final Logger logger = LogManager.getLogger(GamePage.class);
    @Persist
    private Game game;

    @Persist
    private List<Cell> selected;

     @Property
     Cell[] cellSet;

     @Property
     Cell cell;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @Inject
    private Block blockA;

    @Inject
    private Block blockB;

    public Game getGame() {
        return game;
    }

    public String getVisualClass(Cell cell) {
        if (cell.isHit()) {
            if (cell.isBusy()) {
                return "ship-broken";
            } else {
                return "hit";
            }
        } else {
            if (cell.isBusy()) {
                return "busy";
            }
        }
        return "none";
    }

    public String getClassOpponent(Cell cell) {
        if (cell.isHit()) {
            return "hit-opponent";
        }
        return "none";
    }

//    public void addSelected(Cell cell) {
//        selected.add(cell);
//        cell.setBusy(true);
//    }

    public List<CellRow> getCellRowsA() throws WrongCoordinateException {
        List<CellRow> cells = new ArrayList<>();
        Board boardA = game.getPlayerA().getBoard();
        for (int i = 0; i < Board.DESK_SIZE; i++) {
            CellRow cellRow = new CellRow(boardA.getCells(i));
            cells.add(cellRow);
        }
        return cells;
    }

    public List<CellRow> getCellRowsB() throws WrongCoordinateException {
        List<CellRow> cells = new ArrayList<>();
        Board boardB = game.getPlayerB().getBoard();
        for (int i = 0; i < Board.DESK_SIZE; i++) {
            CellRow cellRow = new CellRow(boardB.getCells(i));
            cells.add(cellRow);
        }
        return cells;
    }

    @Log
    void onAjaxA() {
        ajaxResponseRenderer.addRender("middlezone", blockA);
    }

    void onAjaxB() {
        ajaxResponseRenderer.addRender("middlezone", blockB);
    }

    public ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now();
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
