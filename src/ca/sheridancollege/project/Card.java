/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author nancy
 */

/**
 * A class that models a card for a Blackjack game.
 */
public class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    /**
     * Returns the value of the card in Blackjack.
     * @return the value of the card.
     */
    public int getValue() {
        switch (rank) {
            case "Ace":
                return 11;
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                return Integer.parseInt(rank);
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            default:
                throw new IllegalArgumentException("Invalid card rank: " + rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
