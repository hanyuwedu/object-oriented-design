package patterns.adapter;

import patterns.adapter.Items.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * This object list the product and its storage
 */
public class Stock {
    private Map<Product, Integer> storage;

    public Stock() {
        this.storage = new HashMap();
    }

    public void add(Product product, int amount) {
        if (this.storage.containsKey(product)) {
            storage.put(product, storage.get(product) + amount);
        } else {
            storage.put(product, amount);
        }
    }

    public int checkAmout(Product product) {
        if (storage.containsKey(product)) {
            return storage.get(product);
        } else {
            return 0;
        }
    }
}
