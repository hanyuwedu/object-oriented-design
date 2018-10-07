package type.game.blackjack.v1;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void toss(Card card) {
        this.cards.add(card);
    }

    /**
     * Count for the maximum value below 21
     * Ace would be count as 1 or 11, respectively.
     *
     * @return the maximum value for the cards below 21.
     */
    public int count() {
        boolean containsAce = false;
        int sum = 0;

        for (Card card : cards) {
            if (card.getPoint().equals(Point.ACE)) {
                containsAce = true;
            }

            sum += card.getValue();
        }

        if (containsAce && sum <= 11) {
            /**
             * Ace 被视为11只可能出现一次(2 * 11 > 21已然越界)
             */
            System.out.println("This hands can be count as " + sum + " or " + (sum + 10));
            return sum + 10;
        } else {
            System.out.println("This hand counts as " + sum);
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Current Hands are " + this.cards.toString() + ". Max value is " + this.count();
    }
}
