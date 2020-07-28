package tictactoe;

import static tictactoe.Content.*;

public class Board {

    Cell[][] cells;
    private int currentRow;
    private int currentCol;

    public static final int ROWS = 3;
    public static final int COLS = 3;

    public Board() {
        cells = new Cell[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void init() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                cells[row][col].clearCell();
            }
        }
    }

    public boolean isDraw() {
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {
                if (cells[row][col].content == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWon(Content content) {
        return (cells[currentRow][0].content == content
                && cells[currentRow][1].content == content
                && cells[currentRow][2].content == content

                ||

                cells[0][currentCol].content == content
                        && cells[1][currentCol].content == content
                        && cells[2][currentCol].content == content

                || currentRow == currentCol
                && cells[0][0].content == content
                && cells[1][1].content == content
                && cells[2][2].content == content
                || currentRow + currentCol == 2
                && cells[0][2].content == content
                && cells[1][1].content == content
                && cells[2][0].content == content);
    }

    public void drawBoard() {
        System.out.println("---------");
        for (int row = 0; row < ROWS; ++row) {
            System.out.print("| ");
            for (int col = 0; col < COLS; ++col) {
                cells[row][col].drawCell();
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }
}