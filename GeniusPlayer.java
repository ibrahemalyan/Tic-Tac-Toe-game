import java.util.Random;

public class GeniusPlayer implements Player {
    /**
     * function the helps return the first empty cell in the board.
     *
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
     * overrided function which play turn and put marks in the board.
     *
     * @param board game board
     * @param mark  given mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int goodIndex = findFirstIndex(board);

        int row = goodIndex / board.getSize();
        int col = goodIndex % board.getSize();
        board.putMark(mark, row, col);
    }


}
