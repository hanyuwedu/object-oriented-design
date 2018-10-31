package type.game.blackjack.v2.cards;

public enum Suite {
    DIAMOND("♢", 1),
    CLUB("♣", 2),
    HEART("♡", 3),
    SPADE("♠", 4);

    private String symbol;
    private int value;

    Suite(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getValue() {
        return value;
    }
}
