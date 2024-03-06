/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author nancy
 * 
 */


public class BlackjackGame extends Game {

    private GroupOfCards deck;
    private Scanner scanner;

    public BlackjackGame(String name) {
        super(name);
        deck = new GroupOfCards(52);
        scanner = new Scanner(System.in);
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String value : values) {
                deck.getCards().add(new Card(suit, value));
            }
        }
        deck.shuffle();
    }

    @Override
    public void play() {
        for (Player player : getPlayers()) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            System.out.println(player.getName() + "'s turn:");
            for (int i = 0; i < 2; i++) {
                blackjackPlayer.addCard(deck.getCards().remove(0));
            }
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int highestScore = 0;
        Player winner = null;
        for (Player player : getPlayers()) {
            BlackjackPlayer blackjackPlayer = (BlackjackPlayer) player;
            int playerScore = blackjackPlayer.getHandValue();
            if (playerScore > highestScore && playerScore <= 21) {
                highestScore = playerScore;
                winner = player;
            }
        }
        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a score of " + highestScore);
        } else {
            System.out.println("No winner.");
        }
    }
    
}
