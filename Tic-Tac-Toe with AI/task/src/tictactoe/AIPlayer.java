package tictactoe;

public abstract class AIPlayer {
    protected int ROWS = 3;
    protected int COLS = 3;

    protected Cell[][] cells;
    protected Content mySeed;
    protected Content oppSeed;

    public AIPlayer(Board board) {
        cells = board.cells;
    }

    public void setSeed(Content seed) {
        this.mySeed = seed;
        oppSeed = (mySeed == Content.X) ? Content.O : Content.X;
    }

    abstract int[] move();
}