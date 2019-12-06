package eu.roelink.herman;

import eu.roelink.herman.controller.GameController;
import eu.roelink.herman.model.Game;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        Game game = gameController.setupGame();
        gameController.startGame(game);
    }
}
