package ua.hrynko.BL;

import ua.hrynko.exceptions.WrongCoordinateException;

public class Game {
    Player playerA;
    Player playerB;

//    public static Player setSinglePlayer(String name) {
//        if (Objects.isNull(playerA)) {
//            playerA = new Player(name);
//            return playerA;
//        } else {
//            playerB = new Player(name);
//        }
//        return playerB;
//    }

    public void initialize(String playerAName, String playerBName) {
        playerA = new Player(playerAName);
        playerB = new Player(playerBName);
    }

    static void fire(Player target, int x, int y) throws WrongCoordinateException {
        Cell targetCell = target.getBoard().getCell(x, y);
        targetCell.setHit(true);
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
