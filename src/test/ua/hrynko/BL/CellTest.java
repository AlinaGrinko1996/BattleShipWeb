package ua.hrynko.BL;

import org.junit.Test;
import ua.hrynko.BL.Cell;

import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void accessorsTest() {
        Cell cell = new Cell(0, 0, 0);
        cell.setHit(true);
        assertTrue(cell.isHit());

        cell.setBusy(true);
        assertTrue(cell.isBusy());

        cell.toggleBusy();
        assertFalse(cell.isBusy());
    }

    @Test
    public void equalityTest() {
        Cell cellA = new Cell(0, 0, 0);
        cellA.setHit(true);
        cellA.setBusy(true);

        Cell cellB = new Cell(0, 1, 1);
        cellA.setHit(false);
        cellA.setBusy(false);

        assertEquals(cellA, cellB);
    }
}
