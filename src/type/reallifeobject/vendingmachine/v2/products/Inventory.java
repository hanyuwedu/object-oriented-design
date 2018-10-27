package type.reallifeobject.vendingmachine.v2.products;

import type.reallifeobject.vendingmachine.v2.exceptions.InvalidRequestException;
import type.reallifeobject.vendingmachine.v2.exceptions.NotEnoughItemException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {

    private Map<ProductType, Integer> inventory;

    public Inventory(List<ProductType> productTypeList) {
        this.inventory = new HashMap<>();
        for (ProductType productType : productTypeList) {
            this.inventory.put(productType, 0);
        }
    }

    /**
     * 根据input type返回对应的product
     *
     * @param productType 产品的type
     * @return 根据这个class type产生的class
     */
    public Product get(ProductType productType) {
        if (!this.inventory.containsKey(productType) || this.inventory.get(productType) <= 0) {
            throw new NotEnoughItemException("Selected item is not available");
        } else {
            this.inventory.put(productType, this.inventory.get(productType) - 1);
            return productType.getProduct();
        }
    }

    /**
     * 为vending machine填充产品数量
     *
     * @param productType 产品的 type
     * @param amount refill的数量
     */
    public void refill(ProductType productType, int amount) {
        this.updateStorage(productType, amount);
    }

    /**
     * 为指定产品减少一个库存
     *
     * @param productType product的 type
     */
    public void reduce(ProductType productType) {
        this.updateStorage(productType, -1);
    }


    /** 为指定产品更新库存数量
     *
     * @param productType 产品的 type
     * @param amount 更新的库存数量
     */
    private void updateStorage(ProductType productType, int amount) {
        if (!this.inventory.containsKey(productType)) {
            throw new NotEnoughItemException("Selected item is not available");
        } else {
            int updatedStorage = this.inventory.get(productType) + amount;
            if (updatedStorage < 0) {
                throw new InvalidRequestException("Input amount is invalid!");
            }
            this.inventory.put(productType, updatedStorage);
        }
    }

    /**
     * 查看指定产品的库存
     *
     * @param productType 产品的 type
     * @return 对应的库存数量
     */
    public int checkStorage(ProductType productType) {
        if (!this.inventory.containsKey(productType)) {
            return 0;
        }

        return this.inventory.get(productType);
    }

    /**
     * 查看指定产品是否有库存
     *
     * @param productType 产品的 type
     * @return 指定产品是否有库存
     */
    public boolean contains(ProductType productType) {
        return this.checkStorage(productType) > 0;
    }

    @Override
    public String toString() {
        Map<String, Integer> storage = inventory.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        entry -> entry.getValue()));
        return storage.toString();
    }
}
