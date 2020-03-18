package ua.hrynko.BL;

import org.junit.Test;
import ua.hrynko.BL.Board;
import ua.hrynko.BL.Cell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoardTest {
    @Test
    public void boardCells() {
        Board board = new Board();
        Cell[][] cells = board.getCells();

        assertEquals(Board.DESK_SIZE, cells.length);
        assertEquals(Board.DESK_SIZE, cells[0].length);

        assertNotNull(cells[0][0]);
    }
}