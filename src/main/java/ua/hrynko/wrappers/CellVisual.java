package ua.hrynko.wrappers;

import ua.hrynko.BL.Cell;

public class CellVisual {
    private Cell cell;

    public CellVisual(Cell cell) {
        this.cell = cell;
    }

    public String getVisualClass() {
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
}
