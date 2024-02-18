package PokerHand; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
    private static final int NUMOFCARDS = 52;
    private static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private static final int[] SUITS = {0,1,2,3};
//    private static final String[] SUITS = {"Hearts","Diamonds","Spades","Clubs"};
    private ArrayList<Card> deck;
    private int nextToDeal;

    /**
     * Constructor: initialize instance variables
     */
    public Deck() {
        deck = new ArrayList<Card>();
        this.nextToDeal = 0;
        for (int rank = 0; rank <= RANKS.length-1; rank++) {
            for (int suit = 0; suit <= SUITS.length-1; suit++) {
                Card newCard = new Card(RANKS[rank], SUITS[suit]);
                deck.add(newCard);
            }
        }
    }

    /**
     * Return a random index of the deck
     */
    private int shuffleIndex() {
        return ThreadLocalRandom.current().nextInt(size());
    }

    /**
     * Return a shuffled of the original deck
     */
    public void shuffle() {
        for (int i = nextToDeal; i < NUMOFCARDS; i++) {
            int newIndex = shuffleIndex();
            Card originCard = deck.get(i);
            Card newCard = deck.get(newIndex);
            deck.set(i,newCard);
            deck.set(newIndex,originCard);
        }
    }

    /**
     * Deal a single card on top of the deck by removing and return it
     * Big O notation: O(1)
     */
    public Card deal() {
        if (isEmpty()) {
            return null;
        }
        else {
            nextToDeal += 1;
            return deck.get(nextToDeal);
        }
    }

    /**
     * Return the number of cards left in the deck
     */
    public int size() {
        return deck.size() - nextToDeal;
    }

    /**
     * check if the Deck is empty or not
     * @return boolean true if Deck has 0 Cards, false otherwise
     */
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * gather the cards into a Deck
     */
    public void gather() {
        nextToDeal = 0;
    }

    /**
     * Return string presents the deck, each line is a card
     */
    public String toString() {
        String deckStr = "";
        for (Card card : deck) {
            deckStr += card.toString() + "\n";
        }
        return deckStr;
    }
}

