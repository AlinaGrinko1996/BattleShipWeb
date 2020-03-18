package ua.hrynko.BL;

import java.util.List;

/**
 * Object to represent ships
 */
public class Ship {
    private int size;
    private List<Cell> cells;

    public Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public List<Cell> getCells() {
        return cells;
    }

    /**
     * Setting up shops, ensuring that cells are busy for atomicity
     * @param cells cells to initiate ship
     */
    public void setCells(List<Cell> cells) {
        this.cells = cells;
        cells.forEach(cell -> cell.setBusy(true));
    }
}
