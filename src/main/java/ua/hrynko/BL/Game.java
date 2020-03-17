package ua.hrynko.BL;

import ua.hrynko.exceptions.WrongCoordinateException;

public class Game {
    private Player playerA;
    private Player playerB;

    boolean isPlayerACurrent;

    public void initialize(String playerAName, String playerBName) {
        playerA = new Player(1, playerAName);
        playerB = new Player(2, playerBName);
    }

    public void fire(Player target, int id) {
        Cell targetCell = target.getBoard().getCellById(id);
        targetCell.setHit(true);
    }

    public Player getCurrentPlayer() {
        return isPlayerACurrent ? playerA : playerB;
    }

    public boolean isPlayerACurrent() {
        return isPlayerACurrent;
    }

    public void setPlayerACurrent(boolean playerACurrent) {
        isPlayerACurrent = playerACurrent;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }
}
