package PokerHand;

public class CardTester {
    public static void main(String[] args) {
        Testing.startTests();
        Card myCard = new Card("Jack","Spades");
        Card mySecondCard = new Card(14,1);
        Testing.assertEquals("Test get rank", myCard.getRank(),11);
        Testing.assertEquals("Test get suit", myCard.getSuit(), "Spades");
        Testing.assertEquals("Test to string",myCard.toString(), myCard.toString());

        Testing.assertEquals("Test get rank second", mySecondCard.getRank(),14);
        Testing.assertEquals("Test get suit second", mySecondCard.getSuit(), "Hearts");
        Testing.assertEquals("Test to string second",mySecondCard.toString(), mySecondCard.toString());
        Testing.finishTests();
    }
}
