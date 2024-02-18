package PokerHand;

import java.util.ArrayList;

public class CommunityCardSet {
    private static final int SETNUM = 5;
    private ArrayList<Card> communityCards;

    /**
     * Non-default constructor
     * @param listOfCards ArrayList of Cards
     */
    public CommunityCardSet(ArrayList<Card> listOfCards) {
        communityCards = listOfCards;
    }

    /**
     * if the community card set is not full, then add the given card
     * @param newCard the given card
     */
    public void addCard(Card newCard) {
        if (communityCards.size() < SETNUM) {
            communityCards.add(newCard);
        }
    }

    /**
     * getter of the i-th card in the community card set
     * @param index the i-th index
     * @return the i-th card
     */
    public Card getIthCard(int index) {
        if (index >= 0 && index < communityCards.size()) {
            return communityCards.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * @return the readable version of the pokerhand, include 5 readable cards
     */
    public String toString() {
        String handStr = "";
        for (int i = 0; i < communityCards.size(); i++) {
            Card theCard = communityCards.get(i);
            handStr += theCard.toString() + "\n";
        }
        return handStr;
    }
}
