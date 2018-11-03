package patterns.structural.adapter;

import patterns.structural.adapter.Items.Product;
import patterns.structural.adapter.coins.Coin;

public class CoinAdapter extends Product {    /// Need to extends/implement server API object, which must be either an interface or an abstract class

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
        return this.coin.getValue();
    }
}
