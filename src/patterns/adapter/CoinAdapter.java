package patterns.adapter;

public class CoinAdapter extends SellItems {    /// Need to extends/implement server API object, which must be either an interface or an abstract class

    Coin coin;  /// let adaptive user object be in the field

    public CoinAdapter(Coin coin) {
        this.coin = coin;   /// let user object be in the constructor and initialize it
    }


    /// Implements all server API object required methods
    @Override
    public String getProductName() {
        return this.coin.getCoinType().toString().toLowerCase();
    }


    @Override
    public Double getPrice() {
        return null;    /// let not suitable method return null
    }
}
