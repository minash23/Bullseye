/* Name: Mina Shehata
        # Date: 11/29/2022
        # Class: CSC 1120
        # Pledge: I have neither given nor received unauthorized aid on this
      program.
        # Description: This program is an application that simulates the scoring of a dart game.
        # Input: Input x and y values from a file that are based on the positions of the darts.
        # Output: Returns the players' score and the winner of the game.
        */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Play {
    //instantiating variables
    static int countOne = 1;
    static int countTwo = 1;
    static int totalOne = 0;
    static int totalTwo = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("game.txt"));
        // scanning through first 6 values, each iteration takes the next two doubles
        while (countOne <= 3) {
            int score = score(Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble()));
            System.out.println("Score for Pair " + countOne + ": " + score);
            countOne++;
            totalOne += score;
            System.out.println("Player 1 Round One Total Score: " + totalOne);
        }
        // scanning through next 6 values, each iteration takes the next two doubles
        while (countTwo <= 3) {
            int score = score(Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble()));
            System.out.println("Score for Pair " + countTwo + ": " + score);
            countTwo++;
            totalTwo += score;
            System.out.println("Player 2 Round One Total Score: " + totalTwo);
        }
        //printing out winner of first round
        checkWinner();
        // scanning through next 6 values, each iteration takes the next two doubles
        while (countOne <= 6) {
            int score = score(Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble()));
            System.out.println("Score for Pair " + countOne + ": " + score);
            countOne++;
            totalOne += score;
            System.out.println("Player 1 Round Two Total Score: " + totalOne);
        }
        // scanning through next 6 values, each iteration takes the next two doubles
        while (countTwo <= 6) {
            int score = score(Math.abs(scan.nextDouble()), Math.abs(scan.nextDouble()));
            System.out.println("Score for Pair " + countTwo + ": " + score);
            countTwo++;
            totalTwo += score;
            System.out.println("Player 2 Round Two Total Score: " + totalTwo);
        }
        //printing winner of second round
        checkWinner();
    }


        // function that prints out the winner by checking the total of each player and saying the winner
        public static void checkWinner(){
            if (totalOne > totalTwo) {
                System.out.println("SCORE: " + totalOne + " to " + totalTwo + " Player One Wins!");
            }
            if (totalTwo > totalOne) {
                System.out.println("SCORE: " + totalOne + " to " + totalTwo + " Player Two Wins!");
            }
            if (totalTwo == totalOne) {
                System.out.println("SCORE: " + totalOne + " to " + totalTwo + " DRAW");
            }
        }
        // function that takes in the two doubles representing the x and y value
        // x and y values use the pytgaroean theorem to return the score based on the placement of the dart
    public static int score(double a, double b){
        int score = 0;
        System.out.println("X value: " + a);
        System.out.println("Y Value: "  + b);
        if (a*a + b*b <= 3*3){
            score += 100;
        }
        else if (a*a + b*b <= 6*6){
            score += 80;
        }
        else if (a*a + b*b <= 9*9){
            score += 60;
        }
        else if (a*a + b*b <= 12*12){
            score += 40;
        }
        else if (a*a + b*b <= 15*15){
            score += 20;
        }
        return score;
    }
}
