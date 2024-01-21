import java.util.Scanner;

public class HumanPlayer implements Player {
    public static final String INVALID_INPUT = "Invalid coordinates, type again: ";
    Scanner scanner = new Scanner(System.in);

    /**
     * default constructor
     */
    HumanPlayer() {
    }

    /**
     * overrided function which play turn and put marks in the board.
     *
     * @param board game board
     * @param mark  given mark
     */
    @Override
    public void playTurn(Board board, Mark mark) {
        int coordinate;
        System.out.println("Player " + mark + " ,type coordinates: ");
        while (true) {
            coordinate = scanner.nextInt();
            int row = coordinate / board.getSize();
            int col = coordinate % board.getSize();
            if (board.putMark(mark, row, col)) {
                return;
            }

            System.err.println(INVALID_INPUT);

        }

    }
}
