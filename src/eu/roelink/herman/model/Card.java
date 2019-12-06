package eu.roelink.herman.model;

public class Card implements Comparable<Card> {

    private final Rank rank;
    private final Suit suit;

    public Card(Suit suit, Rank rank) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card o) {
        return rank.compareTo(o.getRank());
    }

    @Override
    public String toString() {
        return String.format("%s %s", suit, rank);
    }
}
