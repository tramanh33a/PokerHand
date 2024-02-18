package PokerHand;

import java.util.ArrayList;

public class StudPokerHandTester {
    private static final int STUDNUM = 5;

    /**
     * make ArrayList of Cards to put into the Community card set
     * @param rank the list contains rank of each card
     * @param suit the list contains suit of each card
     * @return ArrayList of Cards to put in the parameter of Community card set
     */
    private static ArrayList<Card> cardList(int[] rank, int[] suit){
        ArrayList<Card> newList = new ArrayList<>();
        for (int i=0; i<STUDNUM;i++) {
            Card myCard = new Card(rank[i],suit[i]);
            newList.add(myCard);
        }
        return newList;
    }

    private static ArrayList<Card> cardList(String[] rank,String[] suit){
        ArrayList<Card> newList = new ArrayList<>();
        for (int i=0; i<STUDNUM;i++) {
            Card myCard = new Card(rank[i],suit[i]);
            newList.add(myCard);
        }
        return newList;
    }

    private static ArrayList<Card> newStudPokerHand(String rank1, String suit1, String rank2, String suit2) {
        ArrayList<Card> cardOf2 = new ArrayList<>();
        Card myCard = new Card(rank1,suit1);
        Card my2ndCard = new Card(rank2,suit2);
        cardOf2.add(myCard);
        cardOf2.add(my2ndCard);
        return cardOf2;
    }

    private static ArrayList<Card> newStudPokerHand(int rank, int suit) {
        ArrayList<Card> cardOf2 = new ArrayList<>();
        Card myCard = new Card(rank,suit);
        cardOf2.add(myCard);
        return cardOf2;
    }

    public static void main(String[] args) {
        Testing.startTests();
        /* Create a Community Card Set */
        int[] rank = {2,3,5,10,11};
        int[] suit = {2,3,0,0,0};
        ArrayList<Card> newCardList = cardList(rank,suit);
        CommunityCardSet theCCSet = new CommunityCardSet(newCardList);

        StudPokerHand firstStud = new StudPokerHand(theCCSet,
                                      newStudPokerHand("2","Spades","King","Hearts"));
        StudPokerHand secondStud = new StudPokerHand(theCCSet,
                                   newStudPokerHand("Ace","Spades","4","Spades"));

        Testing.assertEquals("Testing toString",firstStud.toString(),firstStud.toString());
        Testing.assertEquals("Testing compareTo",firstStud.compareTo(secondStud),-2);
        StudPokerHand oneCardStud = new StudPokerHand(theCCSet,
                                    newStudPokerHand(10,3));
        oneCardStud.addCard(new Card(13,2));
        System.out.println(oneCardStud);
        Testing.assertEquals("Testing addCard",oneCardStud,oneCardStud);

        Testing.finishTests();
    }
}
