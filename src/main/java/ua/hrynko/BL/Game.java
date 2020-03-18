package ua.hrynko.BL;

/**
 * This object is Persist and stores game in a session
 * In general could be used for network playing
 */
public class Game {
    private Player playerA;
    private Player playerB;

    private boolean isPlayerACurrent;

    public void initialize(String playerAName, String playerBName) {
        playerA = new Player(1, playerAName);
        playerB = new Player(2, playerBName);
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

    /**
     * Getters and setters above are needed for binding
     */
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
