public class Game {
    static int DEFAULT_WIN_STREAK = 3;
    private final static int DEFAULT_SIZE = 4;


    Player playerX;
    Player playerO;
    Board board;
    int winStreak;
    Renderer renderer;

    /**
     * constructor
     *
     * @param playerX   1st player
     * @param playerO   2nd player
     * @param size      board size
     * @param winStreak win streak
     * @param renderer  given renderer
     */
    public Game(Player playerX, Player playerO, int size, int winStreak, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.winStreak = winStreak;
        this.renderer = renderer;
        board = new Board(size);

    }

    /**
     * constructor
     *
     * @param playerX  1st player
     * @param playerO  2nd player
     * @param renderer given renderer
     */
    public Game(Player playerX, Player playerO, Renderer renderer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.renderer = renderer;
        this.winStreak = DEFAULT_WIN_STREAK;
        this.board = new Board(DEFAULT_SIZE);
    }

    /**
     * @return win streak
     */
    public int getWinStreak() {
        return winStreak;
    }

    /**
     * method to check if there is a possible win in horizontal way on the board.
     *
     * @param board
     * @param mark
     * @return true if there is a win
     */
    boolean checkWinHorizontal(Board board, Mark mark) {
        for (int i = 0; i < board.getSize(); i += 1) {
            int count = 0;
            for (int j = 0; j < board.getSize(); j += 1) {

                if (board.getBoard()[i][j] == mark) {
                    count += 1;

                } else {
                    count = 0;
                }
                if (count == getWinStreak()) return true;
            }
        }
        return false;
    }

    /**
     * method to check if there is a possible win in vertical way on the board.
     *
     * @param board
     * @param mark
     * @return true if there is a win
     */
    boolean checkWinVertical(Board board, Mark mark) {
        for (int i = 0; i < board.getSize(); i++) {
            int count = 0;
            for (int j = 0; j < board.getSize(); j++) {

                if (board.getBoard()[j][i] == mark) {
                    count += 1;

                } else {
                    count = 0;
                }
                if (count == getWinStreak()) return true;
            }
        }
        return false;
    }

    /**
     * method to check if there is a possible win in diagonal way on the board.
     *
     * @param board
     * @param mark
     * @param direction which diagonal
     * @return true if there is a win
     */
    boolean checkWinDiagonal(Board board, Mark mark, int direction) {
        int count = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getMark(Math.abs(direction - i), Math.abs(direction - i)) == mark) count += 1;
            else count = 0;

        }
        return count == getWinStreak();
    }

    /**
     * @param board
     * @param mark
     * @return true if there is a win in all possible directions
     */
    boolean checkWin(Board board, Mark mark) {

        return checkWinHorizontal(board, mark) || checkWinVertical(board, mark) || checkWinDiagonal(board, mark, 0)
                || checkWinDiagonal(board, mark, board.getSize());
    }

    /**
     * function that count blank cells
     *
     * @param board
     * @return number of blank cells
     */
    int countFreeblocks(Board board) {
        int count = 0;
        for (int i = 0; i < board.getSize(); i++) {

            for (int j = 0; j < board.getSize(); j++) {

                if (board.getBoard()[i][j] == Mark.BLANK) {
                    count += 1;

                }
            }
        }
        return count;

    }

    /**
     * function for run a single match
     *
     * @return mark of the winner
     */
    public Mark run() {
        int turnIndex = 0;
        renderer.renderBoard(board);

        while (true) {

            if (countFreeblocks(board) == 0)
                return Mark.BLANK;
            if (turnIndex % 2 == 0) {
                playerX.playTurn(board, Mark.X);
                renderer.renderBoard(board);
                if (checkWin(board, Mark.X)) return Mark.X;

            } else {
                playerO.playTurn(board, Mark.O);
                renderer.renderBoard(board);
                if (checkWin(board, Mark.O)) return Mark.O;

            }
            turnIndex += 1;

        }
    }
}
