package eu.roelink.herman.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {

    private List<Card> deck;
    private List<Card> wonCards;

    public Inventory(List<Card> deck) {
        this.deck = deck;
        this.wonCards = new ArrayList<>();
    }

    public Inventory() {
        this.deck = new ArrayList<>();
        this.wonCards = new ArrayList<>();
    }

    public boolean hasCards() {
        return !deck.isEmpty() || !wonCards.isEmpty();
    }

    public boolean hasWonCards() {
        return !wonCards.isEmpty();
    }

    // requires deck.size == 0
    public void renewDeck() {
        this.deck = new ArrayList<>(this.wonCards);
        this.wonCards.clear();
        Collections.shuffle(this.deck);
    }

    // Returns null when there are no cards left.
    public Card drawCard() {
        if (deck.size() > 0) {
            return deck.remove(0);
        }

        if (wonCards.size() > 0) {
            renewDeck();
            return deck.remove(0);
        }

        return null;
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public void addCards(List<Card> cards) {
        deck.addAll(cards);
    }

    public void addWonCards(List<Card> cards) {
        wonCards.addAll(cards);
    }

}
