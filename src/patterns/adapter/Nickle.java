package patterns.adapter;

public class Nickle extends Coin {
    CoinType type;

    public Nickle() {
        this.type = CoinType.NICKLE;
    }

    @Override
    public CoinType getCoinType() {
        return this.type;
    }
}
