public interface Player {
    /**
     * function to override in other player classes
     * @param board
     * @param mark
     */
    void playTurn(Board board, Mark mark);
}
