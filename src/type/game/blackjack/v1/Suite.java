package type.game.blackjack.v1;

public enum Suite {
    DIAMOND("♢"),
    CLUB("♣"),
    HEART("♡"),
    SPADE("♠");

    private String symbol;

    Suite(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
