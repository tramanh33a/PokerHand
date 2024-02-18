package PokerHand;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private static final int HANDNUM = 5;

    private static ArrayList<Card> drawHand(Deck deck) {
        ArrayList<Card> hand = new ArrayList<Card>();
        for (int i =0; i < HANDNUM; i++) {
            hand.add(deck.deal());
        }
        return hand;
    }

    private static void gameOver(int score) {
        System.out.println("Your score is " + score);
        System.out.println("GAME OVER");
    }

    public static void main(String[] args) {
        int score = 0;
        Deck theDeck = new Deck();
        theDeck.shuffle();
        boolean GameOver = false;
        while ((theDeck.size() >= 10) && (!GameOver)) {
            PokerHand hand1 = new PokerHand(drawHand(theDeck));
            PokerHand hand2 = new PokerHand(drawHand(theDeck));
            System.out.println("Hand 1: ");
            System.out.println(hand1);
            System.out.println("Hand 2: ");
            System.out.println(hand2);

            Scanner inp = new Scanner(System.in);
            System.out.print("Please input the winner ");
            int choice = inp.nextInt();
            int result = hand1.compareTo(hand2);
            int correctans;
            if (result > 0) {
                correctans = 1;
            }
            else if (result < 0) {
                correctans =2;
            }
            else correctans =0;

            if (choice == correctans) {
                score += 1;
            }
            else if (theDeck.size() < 10) {
                gameOver(score);
                GameOver = true;
            }
            else {
                gameOver(score);
                GameOver = true;
            }
        }
    }
}
