package type.game.blackjack.v2;

import type.game.blackjack.v2.cards.Card;
import type.game.blackjack.v2.cards.Point;
import type.game.blackjack.v2.cards.Suite;
import type.game.blackjack.v2.roles.Dealer;
import type.game.blackjack.v2.roles.Hand;
import type.game.blackjack.v2.roles.Player;
import type.game.blackjack.v2.util.Utility;

import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Guest {
    public static void main(String[] args) {
//        cardTest();
//        deckTest();
//        handTest();
//        playerTest();
        tableTest();
    }



    private static void tableTest() {
        Table macao = new Table(new Dealer());
        Player stanley = new Player("Stanley", 50);

        macao.sit(stanley);
        macao.initialize();
        macao.dealInitialCards();

        stanley.toss(25);
        stanley.toss(10);

        stanley.close();
        stanley.printDetail();
        System.out.println();
        macao.summary();

        macao.leave(stanley);
        System.out.println();

        Player stephen = new Player("Stephen", 100);
        Player paul = new Player("Paul", 150);
        macao.sit(stephen);
        macao.sit(paul);

        /// Exception
//        paul.toss(10);

        macao.initialize();
        macao.dealInitialCards();

        stephen.printDetail();

        paul.close();
        paul.printDetail();

        stephen.toss(55);

        /// Exception
//        stephen.toss(50);
        stephen.toss(30);

        stephen.printDetail();

        // Exception
//        macao.summary();
        stephen.close();

        System.out.println();
        macao.summary();

    }

    private static void playerTest() {
        Table table = new Table(new Dealer());
        Player stephen = new Player("Stephen", 100);
        table.sit(stephen);
        table.initialize();

        stephen.initialize();
        stephen.toss(20);
        stephen.toss(15);
        stephen.printDetail();
        System.out.println();

        stephen.toss(30);
        stephen.printDetail();

        stephen.summary(true);
        System.out.println();

        stephen.toss(25);
        stephen.toss(35);
        stephen.printDetail();

        stephen.close();
        /// Exception
//        stephen.toss(40);

        stephen.summary(false);

        /// Exception
//        stephen.toss(120);
    }

    private static void handTest() {
        Hand hands1 = new Hand();
        Hand hands2 = new Hand();
        Hand hands3 = new Hand();
        Hand hands4 = new Hand();

        hands1.add(new Card(Suite.SPADE, Point.FOUR));
        hands1.add(new Card(Suite.DIAMOND, Point.FIVE));
        hands1.add(new Card(Suite.SPADE, Point.FOUR));
        hands1.add(new Card(Suite.HEART, Point.NINE));
        System.out.println(hands1.count());
        System.out.println();

        hands2.add(new Card(Suite.CLUB, Point.TWO));
        hands2.add(new Card(Suite.HEART, Point.THREE));
        hands2.add(new Card(Suite.DIAMOND, Point.QUEEN));
        System.out.println(hands2.count());

        hands2.add(new Card(Suite.DIAMOND, Point.ACE));
        System.out.println(hands2.count());
        System.out.println();

        hands3.add(new Card(Suite.SPADE, Point.TWO));
        hands3.add(new Card(Suite.DIAMOND, Point.ACE));
        hands3.add(new Card(Suite.DIAMOND, Point.SEVEN));
        System.out.println(hands3.count());

        hands3.add(new Card(Suite.CLUB, Point.ACE));
        System.out.println(hands3.count());
        System.out.println(hands3.toString());
        System.out.println();

        hands4.add(new Card(Suite.DIAMOND, Point.THREE));
        hands4.add(new Card(Suite.SPADE, Point.FIVE));
        hands4.add(new Card(Suite.CLUB, Point.ACE));
        System.out.println(hands4.count());
        hands4.add(new Card(Suite.DIAMOND, Point.SEVEN));
        System.out.println(hands4.count());
    }

    private static void deckTest() {
        List<Card> cardList = Utility.getFullDeck(1);
        System.out.println(cardList);
        System.out.println(cardList.size());

        List<Card> cardList2 = Utility.getFullDeck(2);
        System.out.println(cardList2.size());

        Stack<Card> cardStack = Utility.getRandomStack(3, 15);
        System.out.println(cardStack.toString());
        System.out.println(cardStack.size());

        Random random1 = new Random(1);
        Random random2 = new Random(1);

        Stack<Card> cardStack1 = Utility.getRandomStack(4, 20, random1);
        Stack<Card> cardStack2 = Utility.getRandomStack(4, 20, random2);
        System.out.println(cardStack1.equals(cardStack2));
    }

    private static void cardTest() {
        Card card1 = new Card(Suite.SPADE, Point.TWO);
        Card card2 = new Card(Suite.DIAMOND, Point.NINE);
        Card card3 = new Card(Suite.CLUB, Point.KING);
        Card card4 = new Card(Suite.HEART, Point.QUEEN);
        Card card5 = new Card(Suite.DIAMOND, Point.NINE);

        System.out.println(card1.compareTo(card2));
        System.out.println(card3.compareTo(card1));
        System.out.println(card4.compareTo(card3));
        System.out.println(card2.compareTo(card5));
    }
}
