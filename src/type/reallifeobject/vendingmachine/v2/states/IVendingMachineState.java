package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v2.products.Product;

public interface IVendingMachineState {
    /**
     * 为该vending machine选择产品
     *
     * @param productClass 产品的class type
     * @throws Exception
     */
    void select(Class<? extends Product> productClass) throws Exception;


    /**
     * 为vending machine输入金额
     *
     * @param amount 输入的金额
     * @throws Exception
     */
    void pay(Double amount) throws Exception;

    /**
     * 从vending machine中取出产品
     *
     * @return 即将取得的产品
     * @throws Exception
     */
    Product get() throws Exception;


    /**
     * 取消vending machine正在进行的交易
     */
    void cancel();
}
