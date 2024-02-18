package PokerHand;

public class Card {
    private int rank;
    private String suit;

    /**
     * constructor
     * @param rank String: whole cards (2-10) can either be spelled
     * out like "two" or numeric like "2". Face cards will always be
     * spelled out like "Jack". Case insensitive.
     * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     */
    public Card(String rank, String suit) {
        if (rank.equals("two") || rank.equals("2")) {
            this.rank = 2;
        }
        else if (rank.equals("three") || rank.equals("3")) {
            this.rank = 3;
        }
        else if (rank.equals("four") || rank.equals("4")) {
            this.rank = 4;
        }
        else if (rank.equals("five") || rank.equals("5")) {
            this.rank = 5;
        }
        else if (rank.equals("six") || rank.equals("6")) {
            this.rank = 6;
        }
        else if (rank.equals("seven") || rank.equals("7")) {
            this.rank = 7;
        }
        else if (rank.equals("eight") || rank.equals("8")) {
            this.rank = 8;
        }
        else if (rank.equals("nine") || rank.equals("9")) {
            this.rank = 9;
        }
        else if (rank.equals("ten") || rank.equals("10")) {
            this.rank = 10;
        }
        else if (rank.equals("Jack")) {
            this.rank = 11;
        }
        else if (rank.equals("Queen")) {
            this.rank = 12;
        }
        else if (rank.equals("King")) {
            this.rank = 13;
        }
        else {
            this.rank = 14;
        }
        this.suit = suit;
    }

    /**
     * constructor
     * @param rank integer between 2-14
     * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     */
    public Card(int rank, int suit) {
        if (rank>=2 && rank<=14){
            this.rank = rank;
        }
        else this.rank = 14;

        if (suit == 0) {
            this.suit = "Spades";
        }
        else if (suit == 1) {
            this.suit = "Hearts";
        }
        else if (suit == 2) {
            this.suit = "Clubs";
        }
        else {
            this.suit = "Diamonds";
        }
    }

    /**
     * getter of rank
     * @return int rank
     */
    public int getRank(){
        return rank;
    }

    /**
     * getter of suit
     * @return String suit
     */
    public String getSuit(){
        return suit;
    }

    /**
     * make readable cards like "Queens of Hearts"
     * @return readable cards
     */
    public String toString(){
        String rankStr;
        int theRank = getRank();
        if (theRank == 2){
            rankStr = "2";
        }
        else if (theRank == 3){
            rankStr = "3";
        }
        else if (theRank == 4){
            rankStr = "4";
        }
        else if (theRank == 5){
            rankStr = "5";
        }
        else if (theRank == 6){
            rankStr = "6";
        }
        else if (theRank == 7){
            rankStr = "7";
        }else if (theRank == 8){
            rankStr = "8";
        }
        else if (theRank == 9){
            rankStr = "9";
        }
        else if (theRank == 10){
            rankStr = "10";
        }
        else if (theRank == 11){
            rankStr = "Jack";
        }
        else if (theRank == 12){
            rankStr = "Queen";
        }
        else if (theRank == 13){
            rankStr = "King";
        }
        else if (theRank == 14){
            rankStr = "Ace";
        }
        else rankStr = "Jack";
        return rankStr + " of " + getSuit();
    }
}
