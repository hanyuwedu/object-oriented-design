package type.game.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Utility {
    public static Stack<Card> getRandomStack(int deck, int cards) {
        Stack<Card> cardStack = new Stack<>();
        List<Card> cardList = getFullDeck(deck);
        Collections.shuffle(cardList);
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
