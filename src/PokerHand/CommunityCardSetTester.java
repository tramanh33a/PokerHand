package PokerHand;

import java.util.ArrayList;

public class CommunityCardSetTester {
    private static final int SETNUM = 5;

    /**
     * make ArrayList of Cards to put into the Community card set
     * @param rank the list contains rank of each card
     * @param suit the list contains suit of each card
     * @return ArrayList of Cards to put in the parameter of Community card set
     */
    private static ArrayList<Card> cardList(int[] rank,int[] suit){
        ArrayList<Card> newList = new ArrayList<>();
        for (int i=0; i<SETNUM;i++) {
            Card myCard = new Card(rank[i],suit[i]);
            newList.add(myCard);
        }
        return newList;
    }

    private static ArrayList<Card> cardList(String[] rank,String[] suit){
        ArrayList<Card> newList = new ArrayList<>();
        for (int i=0; i<SETNUM;i++) {
            Card myCard = new Card(rank[i],suit[i]);
            newList.add(myCard);
        }
        return newList;
    }

    public static void main(String[] args) {
        Testing.startTests();
        int[] rank = {2,3,12,10,11};
        int[] suit = {2,3,0,0,5};
        ArrayList<Card> newCardList = cardList(rank,suit);
        CommunityCardSet theCCSet = new CommunityCardSet(newCardList);
        System.out.println(theCCSet);
        Testing.finishTests();
    }
}
