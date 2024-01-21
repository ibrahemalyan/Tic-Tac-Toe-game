import java.util.Random;

public class Tournament {
    int rounds;
    Renderer renderer;
    Player[] players;

    /**
     * constructor
     *
     * @param rounds
     * @param renderer
     * @param players
     */
    Tournament(int rounds, Renderer renderer, Player[] players) {
        this.rounds = rounds;
        this.renderer = renderer;
        this.players = new Player[players.length];
        for (int i = 0; i < players.length; i++) {
            this.players[i] = players[i];
        }

    }

    /**
     * function that runs a number of games and prints the results.
     *
     * @param size
     * @param winStreak
     * @param playerNames
     */
    public void playTournament(int size, int winStreak, String[] playerNames) {
        int winPlayer1 = 0;
        int winPlayer2 = 0;
        int ties = 0;
        Game game;
        Mark winner;
        for (int i = 0; i < rounds; i++) {
            if (i % 2 == 0) {
                game = new Game(players[0], players[1], size, winStreak, renderer);
                winner = game.run();
                if (winner == Mark.X) winPlayer1 += 1;
                else if (winner == Mark.O) winPlayer2 += 1;
                else ties += 1;

            } else {
                game = new Game(players[1], players[0], size, winStreak, renderer);
                winner = game.run();
                if (winner == Mark.X) winPlayer2 += 1;
                else if (winner == Mark.O) winPlayer1 += 1;
                else ties += 1;

            }


        }
        printResults(playerNames, winPlayer1, winPlayer2, ties);


    }

    /**
     * function that prints results and the names of players
     *
     * @param playerNames
     * @param winPlayer1
     * @param winPlayer2
     * @param ties
     */
    private void printResults(String[] playerNames, int winPlayer1, int winPlayer2, int ties) {
        System.out.println("########## Results ##########");
        System.out.println("Player 1, " + playerNames[0] + " won:" + winPlayer1 + " rounds");
        System.out.println("Player 2, " + playerNames[1] + " won:" + winPlayer2 + " rounds");
        System.out.println("Ties: " + ties);
    }

    /**
     * function that validate if player name is valid.
     *
     * @param name
     * @return
     */
    static boolean validateName(String name) {
        String[] validNames = {"clever", "human", "whatever", "genius"};
        for (String n : validNames) {
            if (name.toLowerCase().equals(n)) return true;
        }
        return false;
    }

    /**
     * the main function of the program
     *
     * @param args
     */
    public static void main(String[] args) {
        int roundsCount = Integer.parseInt(args[0]);
        int boardSize = Integer.parseInt(args[1]);
        int winStreak = Integer.parseInt(args[2]);
        String renderType = args[3];
        String playerName1 = args[4];
        String playerName2 = args[5];
        if (roundsCount < 2 || roundsCount > boardSize)
            winStreak = boardSize;
        if (!validateName(playerName1) || !validateName(playerName2)) {
            System.err.println("Choose a player, and start again");
            System.err.println(" The players: [human,clever,whatever,genius]");

            return;
        }
        RendererFactory rendererFactory = new RendererFactory();
        Renderer renderer = rendererFactory.buildRenderer(renderType, boardSize);
        PlayerFactory playerFactory = new PlayerFactory();
        Player player1 = playerFactory.buildPlayer(playerName1);
        Player player2 = playerFactory.buildPlayer(playerName2);
        Player[] players = {
                player1, player2
        };
        Tournament tournament = new Tournament(roundsCount, renderer, players);
        String[] names = {
                playerName1, playerName2
        };
        tournament.playTournament(boardSize, winStreak, names);

    }
}
