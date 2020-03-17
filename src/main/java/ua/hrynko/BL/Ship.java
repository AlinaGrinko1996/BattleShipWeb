package ua.hrynko.BL;

import java.util.List;

public class Ship {
    int size;
   // ShipPlacing placing;

    List<Cell> cells;

    public Ship(int size) {
        this.size = size;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
        cells.forEach(cell -> cell.setBusy(true));
    }
}
