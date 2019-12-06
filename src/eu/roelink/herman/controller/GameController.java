package eu.roelink.herman.controller;

import eu.roelink.herman.checker.Checker;
import eu.roelink.herman.model.*;
import eu.roelink.herman.view.TUIview;
import eu.roelink.herman.view.View;

import java.util.*;

public class GameController {

    private View view;

    public GameController() {
        this.view = new TUIview();
    }

    public Game setupGame() {
        view.showMessage("Welcome to the game of Herman!");
        String answer = view.askInput("How many players will join the game? (1 - 4)");
        int playerAmt;
        while ((playerAmt = Checker.checkPlayerAmtInput(answer)) == -1) {
            answer = view.askInput("Please enter a number between 1 and 4 (inclusive)");
        }

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerAmt; i++) {
            String name = view.askInput("Player " + (i + 1) + ", please enter your name.");
            if (!Checker.checkNameInput(name)) {
                i--;
                view.showMessage("Please enter a non-empty name, not over 15 characters.");
                continue;
            }
            Player player = new Player(name);
            players.add(player);
        }

        handOutCards(players);
        return new Game(players);
    }

    public void startGame(Game game) {
        while (!game.hasEnded()) {
            for (Player player : game.getPlayers()) {
                Card card = player.throwCard();
                game.getTable().throwCard(card, player);
                view.showMessage(String.format("%s threw card %s", player, card));
            }
            List<Player> winners;
            while ((winners = game.getTable().getRoundWinner()).size() > 1) {
                game.getTable().markCardsAsHidden();
                for (Player player : winners) {
                    Card card = player.throwCard();
                    if (card == null) {
                        game.getTable().throwLastCard(player);
                        continue;
                    }
                    game.getTable().throwCard(card, player, true);

                    card = player.throwCard();
                    if (card == null) {
                        game.getTable().throwLastCard(player);
                        continue;
                    }
                    game.getTable().throwCard(card, player);
                }
            }
            List<Card> wonCards = game.getTable().clear();
            Player roundWinner = winners.get(0);
            roundWinner.getInventory().addWonCards(wonCards);
            view.showMessage(String.format("%s won the cards", roundWinner));

            List<Player> toDelete = new ArrayList<>();
            for (Player player : game.getPlayers()) {
                if (!player.getInventory().hasCards()) {
                    toDelete.add(player);
                }
            }

            for (Player player : toDelete) {
                game.getPlayers().remove(player);
            }
        }
        Player winner = game.getWinner();
        view.showMessage(String.format("%s has won the game!", winner.getName()));
    }

    private void handOutCards(List<Player> players) {
        List<Card> cards = initializeCards();
        Collections.shuffle(cards);
        while (!cards.isEmpty()) {
            for (Player player : players) {
                if (cards.isEmpty()) {
                    break;
                }
                Card card = cards.remove(0);
                player.getInventory().addCard(card);
            }
        }
    }

    private List<Card> initializeCards() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        return cards;
    }



}
