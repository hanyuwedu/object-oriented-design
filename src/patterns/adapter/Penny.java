package patterns.adapter;

public class Penny extends Coin{

    CoinType type;

    public Penny() {
        this.type = CoinType.PENNY;
    }

    @Override
    public CoinType getCoinType() {
        return this.type;
    }
}
