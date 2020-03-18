package ua.hrynko.BL;

import org.junit.Test;
import ua.hrynko.BL.Cell;
import ua.hrynko.BL.Ship;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShipTest {
    @Test
    public void accessorsTest() {
        Ship ship = new Ship(5);

        assertEquals(5, ship.getSize());
    }

    @Test
    public void assignCellsTest() {
        Ship ship = new Ship(5);

        List<Cell> cells = new ArrayList<>();
        Cell cell = new Cell(0, 0, 0);
        cell.setBusy(false);
        cells.add(cell);

        ship.setCells(cells);
        assertTrue(cells.get(0).isBusy());
    }
}
