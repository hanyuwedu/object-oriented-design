package patterns.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * This object list the product and its storage
 */
public class Stock {
    private Map<SellItems, Integer> storage;

    public Stock() {
        this.storage = new HashMap();
    }

    public void add(SellItems sellItems, int amount) {
        if (this.storage.containsKey(sellItems)) {
            storage.put(sellItems, storage.get(sellItems) + amount);
        } else {
            storage.put(sellItems, amount);
        }
    }

    public int checkAmout(SellItems sellItems) {
        if (storage.containsKey(sellItems)) {
            return storage.get(sellItems);
        } else {
            return 0;
        }
    }
}
