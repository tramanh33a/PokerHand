package PokerHand;

public class DeckTester {
    public static void main(String[] args) {
        Testing.startTests();
        Deck newDeck = new Deck();
        Testing.assertEquals("Test isEmpty",newDeck.isEmpty(),false);
        Testing.assertEquals("Test size",newDeck.size(),52);
        newDeck.shuffle();
        Testing.assertEquals("Test shuffle",newDeck,newDeck);
        Card drawCard = newDeck.deal();
        Testing.assertEquals("Test deal",drawCard,drawCard);
        Deck emptyDeck = new Deck();
        emptyDeck.gather();
        Testing.assertEquals("Test gather", emptyDeck,emptyDeck);
        Testing.assertEquals("Test to String",newDeck.toString(),newDeck.toString());
        Testing.finishTests();
    }
}
