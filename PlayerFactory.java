public class PlayerFactory {
    /**
     * player factory
     *
     * @param type
     * @return player according to player type.
     */
    public Player buildPlayer(String type) {
        String lowType = type.toLowerCase();
        if (lowType.equals("clever"))
            return new CleverPlayer();
        if (lowType.equals("genius"))
            return new GeniusPlayer();
        if (lowType.equals("human"))
            return new HumanPlayer();
        if (lowType.equals("whatever"))
            return new WhateverPlayer();
        else
            return null;

    }
}