import java.util.Random;

public class CleverPlayer implements Player {
    Random random = new Random();

    /**
     * function that get mark and board and put a mark in random place.
     * @param board game board
     * @param mark given mark
     */
    void randomMove(Board board, Mark mark) {
        int randomCoordinate;
        while (true) {
            randomCoordinate = random.nextInt(board.getSize() * board.getSize());
            int row = randomCoordinate / board.getSize();
            int col = randomCoordinate % board.getSize();
            if (board.putMark(mark, row, col))
                return;
        }
    }

    /**
     * function the helps return the first empty cell in the board.
     * @param board
     * @return
     */

    int findFirstIndex(Board board) {
        int count = 0;
        for (int i = 0; i < board.getSize(); i += 1) {
            for (int j = 0; j < board.getSize(); j += 1) {

                if (board.getMark(i, j) == Mark.BLANK) {
                    return count;

                }
                count += 1;

            }

        }
        return count;
    }
    /**
     * function that get mark and board and put in the first empty cell on the board
     * @param board game board
     * @param mark given mark
     */
    void geniusMove(Board board, Mark mark) {
        int goodIndex = findFirstIndex(board);

        int row = goodIndex / board.getSize();
        int col = goodIndex % board.getSize();
        board.putMark(mark, row, col);
    }

    /**
     * overrided function which play turn and put marks in the board.
     * @param board game board
     * @param mark given mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int choice = random.nextInt(11);
        if (choice % 2 == 0) {
            randomMove(board, mark);
        } else {
            geniusMove(board, mark);
        }
    }
}
