import java.util.Random;

public class WhateverPlayer implements Player {
    Random random = new Random();

    /**
     * over rided function that put mark on board randomly.
     * @param board
     * @param mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int randomCoordinate;
        while (true) {
            randomCoordinate = random.nextInt(board.getSize() * board.getSize());
            int row = randomCoordinate / board.getSize();
            int col = randomCoordinate % board.getSize();
            if (board.putMark(mark, row, col))
                return;
        }

    }
}
