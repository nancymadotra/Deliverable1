/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;
import ca.sheridancollege.project.BlackjackGame;
import ca.sheridancollege.project.BlackjackPlayer;
import ca.sheridancollege.project.Game;
import ca.sheridancollege.project.Player;
/**
 *
 * @author 91935
 */
public class Main {
    
    public static void main(String[] args) {
        // Create a new player with the name "Player 1"
        Player player1 = new Player("Player 1") {
            @Override
            public void play() {
                System.out.println("Player 1 is playing!");
            }
        };

        // Create a new player with the name "Player 2"
        Player player2 = new Player("Player 2") {
            @Override
            public void play() {
                System.out.println("Player 2 is playing!");
            }
        };

        // Call the `play` method on each player
        player1.play();
        player2.play();
    }
}

