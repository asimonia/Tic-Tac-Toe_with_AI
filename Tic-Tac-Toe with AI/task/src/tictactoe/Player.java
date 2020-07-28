package tictactoe;

import static tictactoe.Content.O;
import static tictactoe.Content.X;

public class Player {

    private Content current;
    private Difficulty difficultyP1;
    private Difficulty difficultyP2;

    public Player() {
        this.current = X;
    }

    public Content getCurrent() {
        return current;
    }

    public void setCurrent(Content current) {
        this.current = current;
    }

    public Difficulty getDifficultyP1() {
        return difficultyP1;
    }

    public void setDifficultyP1(Difficulty difficultyP1) {
        this.difficultyP1 = difficultyP1;
    }

    public Difficulty getDifficultyP2() {
        return difficultyP2;
    }

    public void setDifficultyP2(Difficulty difficultyP2) {
        this.difficultyP2 = difficultyP2;
    }

    public void nextPlayer() {
        this.current = (current == X) ? O : X;
    }

    public Difficulty getCurrentDifficult() {
        return (current == X) ? difficultyP1 : difficultyP2;
    }
}