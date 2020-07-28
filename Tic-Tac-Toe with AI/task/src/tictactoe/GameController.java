package tictactoe;

import java.util.Scanner;

import static tictactoe.Content.*;
import static tictactoe.Difficulty.*;
import static tictactoe.GameState.*;

public class GameController {

    private Board board;
    private GameState gameState;
    private Player currentPlayer;

    private static final Scanner scanner = new Scanner(System.in);

    private void checkState() {
        switch (gameState) {
            case X_WIN:
                board.drawBoard();
                System.out.println("X wins");
                break;
            case O_WIN:
                board.drawBoard();
                System.out.println("O wins");
                break;
            case DRAW:
                board.drawBoard();
                System.out.println("Draw");
                break;
        }
    }

    public void playGame() {
        board = new Board();
        initGame();

        do {
            board.drawBoard();
            playerMove();
            updateState();
            checkState();
            currentPlayer.nextPlayer();
        } while (gameState == PLAYING);


    }

    private void menu() {
        while (true) {
            System.out.print("Input command: ");
            String[] command = scanner.nextLine().split("\\s+");

            if (command[0].equals("exit")) {
                System.exit(0);
            }

            if (command[0].equals("start") && command.length == 3) {
                if (command[1].equals("easy")) {
                    currentPlayer.setDifficultyP1(EASY);
                }

                if (command[1].equals("medium")) {
                    currentPlayer.setDifficultyP1(MEDIUM);
                }

                if (command[1].equals("hard")) {
                    currentPlayer.setDifficultyP1(HARD);
                }

                if (command[1].equals("user")) {
                    currentPlayer.setDifficultyP1(HUMAN);
                }

                if (command[2].equals("easy")) {
                    currentPlayer.setDifficultyP2(EASY);
                }

                if (command[2].equals("medium")) {
                    currentPlayer.setDifficultyP2(MEDIUM);
                }

                if (command[2].equals("hard")) {
                    currentPlayer.setDifficultyP2(HARD);
                }

                if (command[2].equals("user")) {
                    currentPlayer.setDifficultyP2(HUMAN);
                }
            }

            if (currentPlayer.getDifficultyP1() == null || currentPlayer.getDifficultyP2() == null) {
                System.out.println("Bad parameters!");
                continue;
            }

            break;
        }

    }


    private void initGame() {
        board.init();
        gameState = PLAYING;
        currentPlayer = new Player();

        menu();
    }

    private void playerMove() {

        if (currentPlayer.getCurrentDifficult() == HUMAN) {
            while (true) {
                System.out.print("Enter the coordinates: ");

                String[] coords = scanner.nextLine().split("\\s+");

                try {
                    Integer.parseInt(coords[0]);
                    Integer.parseInt(coords[1]);
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

                int x = Integer.parseInt(coords[0]);
                int y = Integer.parseInt(coords[1]);


                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if (board.cells[3 - y][x - 1].getContent() == EMPTY) {
                    board.cells[3 - y][x - 1].content = currentPlayer.getCurrent();
                    board.setCurrentRow(3 - y);
                    board.setCurrentCol(x - 1);
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }
        }

        if (currentPlayer.getCurrentDifficult() == EASY) {
            System.out.println("Making move level \"easy\" ");
            AIPlayerEasy aiPlayerEasy = new AIPlayerEasy(board);
            aiPlayerEasy.setSeed(currentPlayer.getCurrent());
            int[] move = aiPlayerEasy.move();
            board.cells[move[0]][move[1]].content = currentPlayer.getCurrent();
            board.setCurrentRow(move[0]);
            board.setCurrentCol(move[1]);
        }

        if (currentPlayer.getCurrentDifficult() == MEDIUM) {
            System.out.println("Making move level \"medium\" ");
            AIPlayerMedium aiPlayerMedium = new AIPlayerMedium(board);
            aiPlayerMedium.setSeed(currentPlayer.getCurrent());
            int[] move = aiPlayerMedium.move();
            board.cells[move[0]][move[1]].content = currentPlayer.getCurrent();
            board.setCurrentRow(move[0]);
            board.setCurrentCol(move[1]);
        }

        if (currentPlayer.getCurrentDifficult() == HARD) {
            System.out.println("Making move level \"hard\" ");
            AIPlayerHard aiPlayerHard = new AIPlayerHard(board);
            aiPlayerHard.setSeed(currentPlayer.getCurrent());
            int[] move = aiPlayerHard.move();
            board.cells[move[0]][move[1]].content = currentPlayer.getCurrent();
            board.setCurrentRow(move[0]);
            board.setCurrentCol(move[1]);
        }

    }

    private void updateState() {
        if (board.hasWon(currentPlayer.getCurrent())) {
            if (currentPlayer.getCurrent() == X) {
                gameState = X_WIN;
            } else {
                gameState = O_WIN;
            }
        } else if (board.isDraw()) {
            gameState = DRAW;
        }

    }

}