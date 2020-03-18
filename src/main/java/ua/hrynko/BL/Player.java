package ua.hrynko.BL;

/**
 * Used to represent player
 * Id could be used to make this game networking
 */
public class Player {
    private int id;
    private String name;
    private Board board;

    public Player(int id, String name) {
        this.id = id;
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
