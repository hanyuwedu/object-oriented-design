package type.game.blackjack.v2.cards;

public class Card implements Comparable<Card> {
    private Suite suite;
    private Point point;

    public Card(Suite suite, Point point) {
        this.suite = suite;
        this.point = point;
    }

    public Suite getSuite() {
        return this.suite;
    }

    public int getValue() {
        return this.point.getValue();
    }

    public Point getPoint() {
        return this.point;
    }

    @Override
    public String toString() {
        return this.suite.getSymbol() + this.point.getSymbol();
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object another) {
        if (another == this) {
            return true;
        }

        if (!(another instanceof Card)) {
            return false;
        }

        return this.toString().equals(another.toString());
    }

    @Override
    public int compareTo(Card another) {
        if (!this.point.equals(another.point)) {
            return this.point.getValue() - another.point.getValue();
        } else {
            return this.suite.getValue() - another.suite.getValue();
        }
    }
}
