package tictactoe;

import java.util.Random;

import static tictactoe.Content.EMPTY;

public class AIPlayerMedium extends AIPlayer{

    public AIPlayerMedium(Board board) {
        super(board);
    }


    @Override
    int[] move() {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if (cells[row][col].getContent() == EMPTY) {
                return new int[] {row, col};
            }
        }

    }
}
