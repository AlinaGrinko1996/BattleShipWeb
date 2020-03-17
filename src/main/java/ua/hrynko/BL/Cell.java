package ua.hrynko.BL;

public class Cell {
    int id;
    int x;
    int y;
    private boolean isHit;
    private boolean isBusy;

    public Cell(int id) {
        this.id = id;
    }

    Ship ship;

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }
}
