package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v2.products.Product;
import type.reallifeobject.vendingmachine.v2.products.ProductType;

public interface IVendingMachineState {
    /**
     * 为该vending machine选择产品
     *
     * @param productType 产品的type
     */
    void select(ProductType productType);


    /**
     * 为vending machine输入金额
     *
     * @param amount 输入的金额
     */
    void pay(Double amount);

    /**
     * 从vending machine中取出产品
     *
     * @return 即将取得的产品
     */
    Product get();


    /**
     * 取消vending machine正在进行的交易
     */
    void cancel();
}
