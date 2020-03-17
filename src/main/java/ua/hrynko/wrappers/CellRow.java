package ua.hrynko.wrappers;

import ua.hrynko.BL.Cell;

import java.util.ArrayList;
import java.util.List;

public class CellRow {
    private List<CellVisual> cellsVisual;

    public CellRow(Cell[] cells) {
        cellsVisual = new ArrayList<>();

        for (Cell cell: cells) {
            CellVisual cellVisual = new CellVisual(cell);
            cellsVisual.add(cellVisual);
        }
    }

    public List<CellVisual> getCellsVisual() {
        return cellsVisual;
    }

    public void setCellsVisual(List<CellVisual> cellsVisual) {
        this.cellsVisual = cellsVisual;
    }
}
