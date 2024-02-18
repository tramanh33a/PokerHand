package PokerHand;

import java.util.ArrayList;

public class StudPokerHand {
    private static int STUDHANDNUM = 2;
    private static int ALLNUM = 7;
    private ArrayList<Card> studHand;
    private CommunityCardSet theCC;
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList) {
        this.studHand = cardList;
        theCC = cc;
    }

    /**
     * if the community card set is not full, then add the given card
     * @param newCard the given card
     */
    public void addCard(Card newCard) {
        if (studHand.size() < STUDHANDNUM) {
            studHand.add(newCard);
        }
    }

    /**
     * getter of the i-th card in the community card set
     * @param index the i-th index
     * @return the i-th card
     */
    public Card getIthCard(int index) {
        if (index >= 0 && index < STUDHANDNUM) {
            return studHand.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * check if an Arraylist of Cards is the size of a hand
     * @param hand the given ArrayList of Cards
     * @return true if size is 5 false otherwise
     */
    private boolean checkHandNum(ArrayList<Card> hand){
        return (hand.size()==ALLNUM-STUDHANDNUM);
    }

    /**
     * delete all the null values in the given ArrayList
     * @param hand the given ArrayList of Cards
     * @return Arraylist of Cards without null values
     */
    private ArrayList<Card> deleteNull(ArrayList<Card> hand) {
        ArrayList<Card> newHand = new ArrayList<>();
        for (int i=0; i<hand.size(); i++) {
            if (hand.get(i) != null) {
                newHand.add(hand.get(i));
            }
        }
        return newHand;
    }

    /**
     * helper to find all possible 5-card PokerHands
     * can make out of the 7 cards StudPokerHand has access to
     * algorithm:
     *  for every index i from 0 to 6
     *   for every index j from i+1 to 6
     *    get a list L of all 7 cards
     *    remove card j from L
     *    remove card i from L
     *    now L is another combo of five card
     *
     * @return ArrayList of PokerHands of all possible 5-card PokerHand
     */
    private ArrayList<PokerHand> getAllFiveCardHands() {
        ArrayList<PokerHand> listOfAll = new ArrayList<>();
        ArrayList<Card> sevenHand = new ArrayList<>();

        for (int i=0; i<ALLNUM; i++) {
            if (i<ALLNUM-STUDHANDNUM) {
                sevenHand.add(theCC.getIthCard(i));
            }
            else sevenHand.add(getIthCard(ALLNUM-i-1));
        }

        for (int i=0; i<ALLNUM; i++) {
            for (int j=i+1; j<ALLNUM; j++) {
                ArrayList<Card> nullPossibleHand = new ArrayList<>(sevenHand);
                nullPossibleHand.set(i,null);
                nullPossibleHand.set(j,null);
                ArrayList<Card> possibleHand = deleteNull(nullPossibleHand);
                PokerHand newPossibleHand = new PokerHand(possibleHand);
                if (checkHandNum(possibleHand)) {
                    listOfAll.add(newPossibleHand);
                }
            }
        }
        return listOfAll;
    }

    private PokerHand getBestFiveCardHand()
    {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other) {
        PokerHand thisStudBestHand = getBestFiveCardHand();
        PokerHand otherStudBestHand = other.getBestFiveCardHand();
        return thisStudBestHand.compareTo(otherStudBestHand);
    }

    /**
     * @return the readable version of the PokerHand, include 5 readable cards
     */
    public String toString() {
        String handStr = "";
        for (int i = 0; i < studHand.size(); i++) {
            Card theCard = studHand.get(i);
            handStr += theCard.toString() + "\n";
        }
        return handStr;
    }

}
