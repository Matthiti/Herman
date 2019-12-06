package eu.roelink.herman.model;

import java.util.*;

public class Table {

    private Map<Card, Player> cards;
    private List<Card> hiddenCards;

    private Map<Player, Card> lastPlayed;

    public Table() {
        cards = new HashMap<>();
        hiddenCards = new ArrayList<>();
        lastPlayed = new HashMap<>();
    }

    public void throwCard(Card card, Player player, boolean hidden) {
        if (hidden) {
            hiddenCards.add(card);
        } else {
            cards.put(card, player);
        }
        lastPlayed.put(player, card);
    }

    public void throwCard(Card card, Player player) {
        throwCard(card, player, false);
    }

     public List<Card> clear() {
        List<Card> allCards = new ArrayList<>(getCards());
        allCards.addAll(hiddenCards);
        cards.clear();
        hiddenCards.clear();
        lastPlayed.clear();
        return allCards;
    }

    //TODO: use
    public void throwLastCard(Player player) {
        Card card = lastPlayed.get(player);
        hiddenCards.remove(card);
        cards.put(card, player);
    }

    public void markCardsAsHidden() {
        hiddenCards.addAll(cards.keySet());
        cards.clear();
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards.keySet());
    }

    public List<Player> getRoundWinner() {
        Card max = Collections.max(cards.keySet());
        List<Player> players = new ArrayList<>();
        for (Card card : cards.keySet()) {
            if (card.compareTo(max) == 0) {
                players.add(cards.get(card));
            }
        }
        return players;
    }

}
