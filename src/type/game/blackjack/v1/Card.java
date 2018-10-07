package type.game.blackjack.v1;

public class Card {
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
}
