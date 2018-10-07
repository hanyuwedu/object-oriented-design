package type.game.blackjack.v1;

import java.util.List;
import java.util.Stack;

public class Guest {
    public static void main(String[] args) {
//        handTest();
//        deckTest();
//        game1();
        game2();
    }

    private static void game2() {
        Player stephen = new Player("Stephen");
        Player paul = new Player("Paul");
        Player sharla = new Player("Sharla");
        Player sandra = new Player("Sandra");

        Board hk = new Board();
        hk.sit(stephen);
        hk.sit(paul);

        /// Exceptions
//        hk.sit(stephen);

        hk.startGame();
        paul.printDetail();
        stephen.printDetail();

        stephen.toss();
        stephen.stop();

        /// Exception
//        hk.summary();
//        stephen.toss();

        paul.stop();
        hk.summary();
        System.out.println();

        /// Round 2
        hk.startGame();
        stephen.stop();
        paul.toss();
        paul.stop();
        hk.summary();
    }

    private static void game1() {
        Player stanley = new Player("Stanley");
        Board macao = new Board();

        macao.sit(stanley);
        macao.startGame();

        stanley.toss();
        stanley.stop();
        macao.summary();
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
    }

    private static void handTest() {
        Hand hands1 = new Hand();
        Hand hands2 = new Hand();
        Hand hands3 = new Hand();

        hands1.toss(new Card(Suite.SPADE, Point.FOUR));
        hands1.toss(new Card(Suite.DIAMOND, Point.FIVE));
        hands1.toss(new Card(Suite.SPADE, Point.FOUR));
        hands1.toss(new Card(Suite.HEART, Point.NINE));
        int count1 = hands1.count();

        hands2.toss(new Card(Suite.CLUB, Point.TWO));
        hands2.toss(new Card(Suite.HEART, Point.THREE));
        hands2.toss(new Card(Suite.DIAMOND, Point.QUEEN));
        int count2 = hands2.count();
        hands2.toss(new Card(Suite.DIAMOND, Point.ACE));
        count2 = hands2.count();

        hands3.toss(new Card(Suite.SPADE, Point.TWO));
        hands3.toss(new Card(Suite.DIAMOND, Point.ACE));
        hands3.toss(new Card(Suite.DIAMOND, Point.SEVEN));
        int count3 = hands3.count();
        System.out.println(count3);
        hands3.toss(new Card(Suite.CLUB, Point.ACE));
        count3 = hands3.count();
        System.out.println(count3);
        System.out.println(hands3.toString());
    }
}
