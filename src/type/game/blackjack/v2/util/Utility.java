package type.game.blackjack.v2.util;

import type.game.blackjack.v2.cards.Card;
import type.game.blackjack.v2.cards.Point;
import type.game.blackjack.v2.cards.Suite;

import java.util.*;

public class Utility {
    public static Stack<Card> getRandomStack(int deck, int cards) {
        return getRandomStack(deck, cards, new Random());
    }

    public static Stack<Card> getRandomStack(int deck, int cards, Random random) {
        Stack<Card> cardStack = new Stack<>();
        List<Card> cardList = getFullDeck(deck);
        Collections.shuffle(cardList, random);
        for (int i = 1; i <= cards; i++) {
            cardStack.add(cardList.get(i));
        }

        return cardStack;
    }

    public static List<Card> getFullDeck(int deck) {
        List<Card> cardList = new ArrayList<>();
        for (int i = 1; i <= deck; i++) {
            for (Suite suite : Suite.values()) {
                for (Point point : Point.values()) {
                    cardList.add(new Card(suite, point));
                }
            }
        }
        return cardList;
    }
}
