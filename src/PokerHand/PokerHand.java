package PokerHand; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.Collections;

public class PokerHand {
    private static final int CARDNUM = 5;
    private static final int FIRST = 0;
    private static final String[] TYPE = {"High cards", "1 pair", "2 pairs", "Flush"};
    private ArrayList<Card> pokerHand;

    /**
     * Non-default constructor
     * @param cardList cards that are in the hand
     */
    public PokerHand(ArrayList<Card> cardList) {
        this.pokerHand = cardList;
    }

    /**
     * add cards when the pokerhand is not full
     * @param newCard the given card
     */
    public void addCard(Card newCard) {
        if (pokerHand.size() < CARDNUM) {
            pokerHand.add(newCard);
        }
    }

    /**
     * get the ith card in the pokerhand
     * @param index
     * @return
     */
    public Card getIthCard(int index) {
        if (index >= 0 && index < pokerHand.size()) {
            return pokerHand.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * based on the TYPE[] to define the int
     * @return
     */
    private int type() {
        if (isFlush()) {
            return 3;
        }
        else if (numPairs() == 2) {
            return 2;
        }
        else if (numPairs() == 1) {
            return 1;
        }
        else return 0;
    }


    /**
     * get the suit of the ith card
     * @param index
     * @return
     */
    private String getCardSuit(int index) {
        return getIthCard(index).getSuit();
    }

    /**
     * get the rank of the ith card
     * @param index index of the ith card
     * @return
     */
    private int getCardRank(int index) {
        return getIthCard(index).getRank();
    }

    /**
     * check if the hand is a flush or not
     */
    private boolean isFlush() {
        String originalSuit = this.getCardSuit(FIRST);
        for (int i = 1; i < CARDNUM; i++) {
            String suit = this.getCardSuit(i);
            if (! originalSuit.equals(suit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * getter of list of ranks without the values getting repeated
     */
    private ArrayList<Integer> getOneRank() {
        ArrayList<Integer> rankList = new ArrayList<Integer>();
        for (int i = 0; i < CARDNUM; i++) {
            if (!rankList.contains(getCardRank(i))) {
                rankList.add(getCardRank(i));
            }
        }
        return rankList;
    }

    /**
     * getter of list of complete ranks of the hand
     */
    private ArrayList<Integer> getRank() {
        ArrayList<Integer> rankList = new ArrayList<Integer>();
        for (int i = 0; i < CARDNUM; i++) {
            rankList.add(getCardRank(i));
        }
        return rankList;
    }

    /**
     * find the occurences a number is the card's rank in the poker hand
     * @param num number wish to find
     * @return occurences that num is in the pokerhand ranks
     */
    private int countNum(int num) {
        int count = 0;
        for (int i = 0; i < CARDNUM; i++) {
            if (getCardRank(i) == num) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * count number of pairs in the poker hand
     * @return number of pairs
     */
    private int numPairs() {
        int count = 0;
        for (int i = 0; i < getOneRank().size(); i++) {
            int occurrences = getOccur(i);
            if (occurrences == 4) {
                count += 2;
            }
            else if ((occurrences == 3) || (occurrences == 2)) {
                count += 1;
            }
        }
        return count;
    }

    /**
     * getter of the times that a rank is repeated in the PokerHand
     * @param index the given index
     * @return the times of occurrences of a rank
     */
    private int getOccur(int index) {
        return countNum(getOneRank().get(index));
    }

    private ArrayList<Integer> pairs () {
        ArrayList<Integer> listOfPairs = new ArrayList<>();
        for (int i = 0; i < getOneRank().size(); i++) {
            int occurrences = getOccur(i);
            if (this.type() == 2) {
                if (occurrences == 4) {
                    listOfPairs.add(getCardRank(i));
                    listOfPairs.add(getCardRank(i));
                }
                else if (occurrences == 2) {
                    listOfPairs.add(getCardRank(i));
                }
            }
            else {
                if (occurrences >= 2) {
                    listOfPairs.add(getCardRank(i));
                }
            }
        }
        return listOfPairs;
    }

    /**
     * check if 2 hands are the same type or not
     * @param other the hand to compare this hand to
     * @return true if same type false otherwise
     */
    private boolean sameType(PokerHand other) {
        if (this.type() - other.type() == 0) {
            return true;
        }
        else return false;
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other) {
        if (sameType(other)) {
            ArrayList<Integer> handRank = this.getRank();
            ArrayList<Integer> otherRank = other.getRank();

            Collections.sort(handRank,Collections.reverseOrder());
            Collections.sort(otherRank,Collections.reverseOrder());

             for (int i = 0; i < CARDNUM; i++) {
                    int thisCardRank = handRank.get(i);
                    int otherCardRank = otherRank.get(i);
                    if (thisCardRank != otherCardRank) {
                        return thisCardRank - otherCardRank;
                    }
                }
                return 0;
            }
        else {
            return this.type() - other.type();
        }

    }

    /**
     * @return the readable version of the pokerhand, include 5 readable cards
     */
    public String toString() {
        String handStr = "";
        for (int i = 0; i < pokerHand.size(); i++) {
            Card theCard = pokerHand.get(i);
            handStr += theCard.toString() + "\n";
        }
        return handStr;
    }
}


