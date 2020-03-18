package ua.hrynko.BL;

import java.util.*;

/**
 * Class to represent border
 * I planned to add checks for amount of ships, correct location an so on
 */
public class Board {
    public static int DESK_SIZE = 10;

    private Cell[][] cells;
    private List<Ship> ships;

    /**
     * Unused getter and setter are needed for binding
     */
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
