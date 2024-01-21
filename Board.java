public class Board {
    private final static int DEFAULT_SIZE = 4;
    int size;
    Mark[][] board;

    /**
     * default constructor./
     */
    Board() {
        this.size = DEFAULT_SIZE;
        board = new Mark[DEFAULT_SIZE][DEFAULT_SIZE];
        initBoard();

    }

    /***
     * method that initialize board elements with Mark.Blank
     */
    private void initBoard() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                board[i][j] = Mark.BLANK;
            }
        }
    }

    /**
     * Constructor with param size.
     * which construct board with given size.
     *
     * @param size size of the board.
     */
    Board(int size) {
        this.size = size;
        board = new Mark[this.size][this.size];
        initBoard();
    }

    /**
     * @return size of board
     */
    public int getSize() {
        return size;
    }

    /**
     * function that put given mark on given coordinates.
     *
     * @param mark given mark
     * @param row  coordinate
     * @param col  coordinate
     * @return true if mark well-placed otherwise false
     */
    public boolean putMark(Mark mark, int row, int col) {
        if (row >= 0 && row < this.size && col >= 0 && col < this.size && board[row][col] == Mark.BLANK) {
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    /**
     * @return return the board array
     */
    public Mark[][] getBoard() {
        return this.board;
    }

    /**
     * @param row coordinate
     * @param col coordinate
     * @return mark in the place (row,col) from the board
     */
    public Mark getMark(int row, int col) {
        if (row >= 0 && row < this.size && col >= 0 && col < this.size) return board[row][col];
        return Mark.BLANK;
    }
}
