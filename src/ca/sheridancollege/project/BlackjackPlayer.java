/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;


/**
 *
 * @author nancy
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that models a blackjack player.
 */



/**
 * A class that models a blackjack player.
 */
public class BlackjackPlayer extends Player {

    private final ArrayList<Card> hand; // The player's hand of cards

    public BlackjackPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    // Adds a card to the player's hand
    public void addCard(Card card) {
        hand.add(card);
    }

    // Retrieves the player's hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Calculates the total value of the player's hand
    public int getHandValue() {
        int value = 0;
        int aces = 0;
        for (Card card : hand) {
            String rank = card.getRank();
            if ("Ace".equals(rank)) {
                aces++;
                value += 11;
            } else if ("10".equals(rank) || "Jack".equals(rank) || "Queen".equals(rank) || "King".equals(rank)) {
                value += 10;
            } else {
                value += Integer.parseInt(rank);
            }
        }
        
        // Adjust for the ace value if necessary
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        
        return value;
    }

    // Displays the player's hand
    public void displayHand() {
        System.out.println(getName() + "'s hand: " + hand + " (Total value: " + getHandValue() + ")");
    }

    // Determines if the player wants to hit or stand
    public boolean decideHit(Scanner scanner) {
        System.out.println(getName() + ", do you want to hit or stand? (Enter 'hit' or 'stand')");
        String decision = scanner.nextLine().trim().toLowerCase();
        return "hit".equals(decision);
    }

    // Contains the logic for the player's turn
    @Override
    public void play() {
        try (Scanner scanner = new Scanner(System.in)) {
            displayHand();
            while (getHandValue() < 21 && decideHit(scanner)) {
                // In a real game, you would have a mechanism to draw a card from the deck here
                System.out.println(getName() + " chooses to hit.");
                // For example: addCard(deck.drawCard());
                displayHand();
            }
            if (getHandValue() > 21) {
                System.out.println(getName() + " busts with a hand value of " + getHandValue() + ".");
            } else {
                System.out.println(getName() + " stands with a hand value of " + getHandValue() + ".");
            }
        }
    }
}


