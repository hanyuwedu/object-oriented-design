package patterns.adapter;

import patterns.adapter.Items.BottleWater;
import patterns.adapter.Items.Coke;
import patterns.adapter.coins.Nickle;
import patterns.adapter.coins.Penny;

public class Guest {
    public static void main(String[] args) {
        Coke cokeItem = new Coke();
        BottleWater bottleWaterItem = new BottleWater();
        Stock stock = new Stock();
        stock.add(cokeItem, 10);
        stock.add(bottleWaterItem, 2);
        stock.add(cokeItem, 20);

        System.out.println(stock.checkAmout(cokeItem));
        System.out.println(stock.checkAmout(bottleWaterItem));


        Nickle nickle = new Nickle();
        Penny penny = new Penny();
        CoinAdapter nickleAdapter = new CoinAdapter(nickle);
        CoinAdapter pennyAdapter = new CoinAdapter(penny);

        System.out.println(nickleAdapter.getProductName());
        System.out.println(pennyAdapter.getProductName());

        Stock coinStock = new Stock();
        coinStock.add(nickleAdapter, 100);      /// Use adapter as a normal object
        coinStock.add(pennyAdapter, 3000);
        coinStock.add(nickleAdapter, 400);
        System.out.println(coinStock.checkAmout(nickleAdapter));
    }
}
