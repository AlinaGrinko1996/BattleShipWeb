package ua.hrynko.BL;

import ua.hrynko.exceptions.PlacingException;
import ua.hrynko.exceptions.WrongCoordinateException;

import java.util.*;

public class Board {
    public static int DESK_SIZE = 10;

    private Cell[][] cells;
    private List<Ship> ships;

    //needed for binding
    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Board() {
        cells = getCellInitializedArray();
        ships = new ArrayList<>();
    }

    public void placeCells(List<Integer> ids) {
        ids.forEach(id -> {
            Cell cell = getCellById(id);
            //todo - here must be check for acceptable placement,
            cell.setBusy(true);
        });
    }

    public Cell getCellById(int cellId) {
        for (Cell[] cellsRow : cells) {
            for (Cell cell: cellsRow) {
                if (cell.getId() == cellId) {
                    return cell;
                }
            }
        }
        return null;
    }

    private Cell[][] getCellInitializedArray() {
        Cell[][] result = new Cell[DESK_SIZE][DESK_SIZE];
        for (int i = 0; i < DESK_SIZE; i++) {
            Cell[] row = new Cell[DESK_SIZE];
            for (int j = 0; j < DESK_SIZE; j++) {
                row[j] = new Cell(i * DESK_SIZE + j, i, j);
            }
            result[i] = row;
        }
        return result;
    }
}
