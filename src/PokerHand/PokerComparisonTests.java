package PokerHand;

/**
 *  Project 3: Card Game in Java
 *  Author: Anh Nguyen
 *
 *  I affirm that I have carried out the attached academic endeavors with full academic honesty, in
 * accordance with the Union College Honor Code and the course syllabus.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class PokerComparisonTests {
    private static int HANDNUM = 5;

    private static ArrayList<Card> myHand(ArrayList<Integer> rank, ArrayList<Integer> suit) {
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < HANDNUM; i++) {
            hand.add(new Card(rank.get(i),suit.get(i)));
        }
        return hand;
    }

    private static void test1() {
        ArrayList<Card> test1 = new ArrayList<>();
        test1 = myHand(new ArrayList<Integer>(Arrays.asList(2,6,12,6,10)),
                new ArrayList<Integer>(Arrays.asList(1,2,0,3,1)));
        PokerHand theTest1 = new PokerHand(test1);

        ArrayList<Card> test2 = new ArrayList<>();
        test2 = myHand(new ArrayList<Integer>(Arrays.asList(5,5,2,5,11)),
                new ArrayList<Integer>(Arrays.asList(0,1,2,3,2)));
        PokerHand theTest2 = new PokerHand(test2);

        Testing.assertEquals("Test 1 compareTo of two 1-pair hands/ different pairs",
                             theTest1.compareTo(theTest2), 1);
    }

    private static void test2() {
        ArrayList<Card> test1 = new ArrayList<>();
        test1 = myHand(new ArrayList<Integer>(Arrays.asList(9,10,12,7,4)),
                new ArrayList<Integer>(Arrays.asList(1,1,1,1,1)));
        PokerHand theTest1 = new PokerHand(test1);

        ArrayList<Card> test2 = new ArrayList<>();
        test2 = myHand(new ArrayList<Integer>(Arrays.asList(5,10,2,10,3)),
                new ArrayList<Integer>(Arrays.asList(1,1,0,1,1)));
        PokerHand theTest2 = new PokerHand(test2);

        Testing.assertEquals("Test 2 flush vs 1 pair ", theTest1.compareTo(theTest2), 2);
    }

    private static void test3() {
        ArrayList<Card> test1 = new ArrayList<>();
        test1 = myHand(new ArrayList<Integer>(Arrays.asList(2,6,12,6,10)),
                new ArrayList<Integer>(Arrays.asList(1,2,0,3,1)));
        PokerHand theTest1 = new PokerHand(test1);

        ArrayList<Card> test2 = new ArrayList<>();
        test2 = myHand(new ArrayList<Integer>(Arrays.asList(11,7,7,4,4)),
                new ArrayList<Integer>(Arrays.asList(0,1,2,3,2)));
        PokerHand theTest2 = new PokerHand(test2);

        Testing.assertEquals("Test 3 1 pair vs 2 pairs",
                             theTest1.compareTo(theTest2), -1);
    }

    private static void test4() {
        ArrayList<Card> fouTest1 = new ArrayList<>();
        fouTest1 = myHand(new ArrayList<Integer>(Arrays.asList(6, 2, 3, 4, 5)),
                new ArrayList<Integer>(Arrays.asList(2,3,2,1,0)));
        PokerHand fourthTest1 = new PokerHand(fouTest1);

        ArrayList<Card> fouTest2 = new ArrayList<>();
        fouTest2 = myHand(new ArrayList<Integer>(Arrays.asList(2, 2, 6, 7, 6)),
                new ArrayList<Integer>(Arrays.asList(1,2,2,2,3)));
        PokerHand fourthTest2 = new PokerHand(fouTest2);
        Testing.assertEquals("Test 4 high cards vs 2 pairs",
                             fourthTest1.compareTo(fourthTest2), -2);
    }

    private static void test5() {
        ArrayList<Card> fiTest1 = new ArrayList<>();
        fiTest1 = myHand(new ArrayList<Integer>(Arrays.asList(5, 6, 7, 10, 2)),
                new ArrayList<Integer>(Arrays.asList(2,3,1,1,1)));
        PokerHand fifthTest1 = new PokerHand(fiTest1);

        ArrayList<Card> fiTest2 = new ArrayList<>();
        fiTest2 = myHand(new ArrayList<Integer>(Arrays.asList(10, 6, 4, 3, 2)),
                new ArrayList<Integer>(Arrays.asList(1,2,0,1,2)));
        PokerHand fifthTest2 = new PokerHand(fiTest2);
        Testing.assertEquals("Test 5 high cards diff on second high card ",
                             fifthTest1.compareTo(fifthTest2), 1);
    }

    private static void test6() {
        ArrayList<Card> sixTest1 = new ArrayList<>();
        sixTest1 = myHand(new ArrayList<Integer>(Arrays.asList(2, 6, 11, 12, 5)),
                new ArrayList<Integer>(Arrays.asList(1,1,2,3,0)));
        PokerHand sixthTest1 = new PokerHand(sixTest1);

        ArrayList<Card> sixTest2 = new ArrayList<>();
        sixTest2 = myHand(new ArrayList<Integer>(Arrays.asList(5, 12, 6, 2, 11)),
                new ArrayList<Integer>(Arrays.asList(1,3,0,1,2)));
        PokerHand sixthTest2 = new PokerHand(sixTest2);
        Testing.assertEquals("Test 6 equal ", sixthTest1.compareTo(sixthTest2), 0);

    }

    private static void test7() {
        ArrayList<Card> sevTest1 = new ArrayList<>();
        sevTest1 = myHand(new ArrayList<Integer>(Arrays.asList(12, 3, 6, 3, 12)),
                new ArrayList<Integer>(Arrays.asList(1,2,2,0,2)));
        PokerHand seventhTest1 = new PokerHand(sevTest1);

        ArrayList<Card> sevTest2 = new ArrayList<>();
        sevTest2 = myHand(new ArrayList<Integer>(Arrays.asList(10, 12, 3, 3, 12)),
                new ArrayList<Integer>(Arrays.asList(0,0,2,3,1)));
        PokerHand seventhTest2 = new PokerHand(sevTest2);
        Testing.assertEquals("Test 7 2 pairs hands diff on high card",
                             seventhTest1.compareTo(seventhTest2), -4);
    }

    private static void test8() {
        ArrayList<Card> eigTest1 = new ArrayList<>();
        eigTest1 = myHand(new ArrayList<Integer>(Arrays.asList(14, 2, 3, 3, 14)),
                new ArrayList<Integer>(Arrays.asList(1,2,3,2,1)));
        PokerHand eightTest1 = new PokerHand(eigTest1);

        ArrayList<Card> eigTest2 = new ArrayList<>();
        eigTest2 = myHand(new ArrayList<Integer>(Arrays.asList(13, 11, 13, 13, 13)),
                new ArrayList<Integer>(Arrays.asList(1,2,0,3,2)));
        PokerHand eightTest2 = new PokerHand(eigTest2);
        Testing.assertEquals("Test 8 2 pairs vs 4 of a kind (Aces/3s and Kings)",
                             eightTest1.compareTo(eightTest2), 1);
    }

    private static void test9() {
        ArrayList<Card> ninTest1 = new ArrayList<>();
        ninTest1 = myHand(new ArrayList<Integer>(Arrays.asList(3, 3, 13, 2, 13)),
                new ArrayList<Integer>(Arrays.asList(1,1,1,0,2)));
        PokerHand ninthTest1 = new PokerHand(ninTest1);

        ArrayList<Card> ninTest2 = new ArrayList<>();
        ninTest2 = myHand(new ArrayList<Integer>(Arrays.asList(6, 5, 12, 5, 12)),
                new ArrayList<Integer>(Arrays.asList(2,0,2,3,1)));
        PokerHand ninthTest2 = new PokerHand(ninTest2);
        Testing.assertEquals("Test 9 two 2 pairs diff on first pair",
                             ninthTest1.compareTo(ninthTest2), 1);
    }


    public static void main(String[] args) {
        Testing.startTests();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        Testing.finishTests();
    }
}
