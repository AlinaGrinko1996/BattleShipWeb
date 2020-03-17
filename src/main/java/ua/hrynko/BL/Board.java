package ua.hrynko.BL;

import ua.hrynko.exceptions.PlacingException;
import ua.hrynko.exceptions.WrongCoordinateException;

import java.util.*;

public class Board {
    public static int DESK_SIZE = 10;

    Cell[][] cells;
    List<Ship> ships;

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



//    public void placeAShip(int x, int y, int size, ShipPlacing placing) throws PlacingException {
//        List<Cell> cellsForShip = collectCellsForShip(x, y, size, placing);
//        Ship ship = new Ship(size);
//        ship.setCells(cellsForShip);
//
//        ships.add(ship);
//    }

//    private List<Cell> collectCellsForShip(int x, int y, int size, ShipPlacing placing) throws PlacingException {
//        List<Cell> candidateCells = new ArrayList<>();
//        if (placing == ShipPlacing.HORIZONTAL) {
//            if (!insideTheBorder(x + size, y)) {
//                throw new PlacingException("Cells out of allowed region!");
//            }
//
//            for (int i = x; i < (x + size); i++) {
//                candidateCells.add(cells[i][y]);
//            }
//        } else {
//            if (!insideTheBorder(x,y + size)) {
//                throw new PlacingException("Cells out of allowed region!");
//            }
//
//            candidateCells.addAll(Arrays.asList(cells[x]).subList(y, (y + size)));
//        }
//
//        if (candidateCells.stream().anyMatch(Cell::isBusy)) {
//            throw new PlacingException("Cells overlap!");
//        }
//
//        Set<Cell> neighbours = new HashSet<>();
//        candidateCells.forEach(cell ->
//            neighbours.addAll(getNeighbours(cell))
//        );
//
//        if (neighbours.stream().anyMatch(Cell::isBusy)) {
//            throw new PlacingException("Too close to neighbours!");
//        }
//
//        return candidateCells;
//    }

    private boolean insideTheBorder(int x, int y) {
        return (x >= 0) && (x < DESK_SIZE) && (y >= 0) && (y < DESK_SIZE);
    }

    private List<Cell> getNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();

        if (insideTheBorder(cell.x, cell.y + 1)) {
            neighbours.add(cells[cell.x][cell.y + 1]);
        }

        if (insideTheBorder(cell.x, cell.y - 1)) {
            neighbours.add(cells[cell.x][cell.y - 1]);
        }

        if (insideTheBorder(cell.x + 1, cell.y)) {
            neighbours.add(cells[cell.x + 1][cell.y + 1]);
        }

        if (insideTheBorder(cell.x - 1, cell.y)) {
            neighbours.add(cells[cell.x - 1][cell.y]);
        }
        return neighbours;
    }

    public Cell getCell(int x, int y) throws WrongCoordinateException {
        if (insideTheBorder(x, y)) {
            return cells[x][y];
        }
        throw new WrongCoordinateException("Coordinated of cell are incorrect!");
    }

    public Cell[] getCells(int x) throws WrongCoordinateException {
        if (insideTheBorder(x, 0)) {
            return cells[x];
        }
        throw new WrongCoordinateException("Coordinated of cell are incorrect!");
    }

    private Cell[][] getCellInitializedArray() {
        Cell[][] result = new Cell[DESK_SIZE][DESK_SIZE];
        for (int i = 0; i < DESK_SIZE; i++) {
            Cell[] row = new Cell[DESK_SIZE];
            for (int j = 0; j < DESK_SIZE; j++) {
                row[j] = new Cell(i * DESK_SIZE + j);
            }
            result[i] = row;
        }
        return result;
    }
}
