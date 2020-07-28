package tictactoe;

public class Cell {

    private int row;
    private int col;
    Content content;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clearCell();
    }

    public void clearCell() {
        this.content = Content.EMPTY;
    }

    public void drawCell() {
        switch (content) {
            case X:
                System.out.print("X");
                break;
            case O:
                System.out.print("O");
                break;
            case EMPTY:
                System.out.print(" ");
                break;
        }
    }

    public Content getContent() {
        return content;
    }
}