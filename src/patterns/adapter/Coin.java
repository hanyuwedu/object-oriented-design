package patterns.adapter;

public abstract class Coin {
    public abstract CoinType getCoinType();
    public Double getValue() {
        return this.getCoinType().getValue();
    }
}
