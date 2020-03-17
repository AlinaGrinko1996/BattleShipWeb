package ua.hrynko.BL;

public class Player {
    String name;
    private Board board;

    public Player(String name) {
        this.name = name;
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
