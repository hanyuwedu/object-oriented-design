package type.reallifeobject.vendingmachine.v2.products;

import type.reallifeobject.vendingmachine.v2.exceptions.InvalidRequestException;
import type.reallifeobject.vendingmachine.v2.exceptions.NotEnoughItemException;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {
    /*
     * 写了茫茫多的Class<? extends Product>，可以写成generic吗？
     */
    private Map<Class<? extends Product>, Integer> inventory;

    public Inventory(Class<? extends Product> ...productClassList) {
        this.inventory = new HashMap<>();
        for (Class<? extends Product> productClass : productClassList) {
            this.inventory.put(productClass, 0);
        }
    }

    public Product get(Class<? extends Product> productClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (!this.inventory.containsKey(productClass) || this.inventory.get(productClass) <= 0) {
            throw new NotEnoughItemException("Selected item is not available");
        } else {
            this.inventory.put(productClass, this.inventory.get(productClass) - 1);
            return productClass.getDeclaredConstructor().newInstance();
        }
    }

    public void refill(Class<? extends Product> productClass, int amount) {
        this.updateStorage(productClass, amount);
    }

    public void reduce(Class<? extends Product> productClass) {
        this.updateStorage(productClass, -1);
    }

    private void updateStorage(Class<? extends Product> productClass, int amount) {
        if (!this.inventory.containsKey(productClass)) {
            throw new NotEnoughItemException("Selected item is not available");
        } else {
            int updatedStorage = this.inventory.get(productClass) + amount;
            if (updatedStorage < 0) {
                throw new InvalidRequestException("Input amount is invalid!");
            }
            this.inventory.put(productClass, updatedStorage);
        }
    }

    public int checkStorage(Class<? extends Product> productClass) {
        if (!this.inventory.containsKey(productClass)) {
            return 0;
        }

        return this.inventory.get(productClass);
    }

    public boolean contains(Class<? extends Product> productClass) {
        return this.checkStorage(productClass) > 0;
    }

    @Override
    public String toString() {
        Map<String, Integer> storage = inventory.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> {
                            try {
                                /*
                                 * 每次为了取得一个参数都需要很长的表述建立新对象，以及抛一大堆的异常。有何好的解决方案？
                                 */
                                return entry.getKey().getDeclaredConstructor().newInstance().getName();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return "";
                        },
                        entry -> entry.getValue()));
        return storage.toString();
    }
}
