package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v1.exceptions.NotEnoughItemException;
import type.reallifeobject.vendingmachine.v2.VendingMachine;
import type.reallifeobject.vendingmachine.v2.exceptions.ItemNotSelectedException;
import type.reallifeobject.vendingmachine.v2.products.Product;
import type.reallifeobject.vendingmachine.v2.products.ProductType;

public class InitialState extends AbstractVendingMachineState {
    public InitialState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    /**
     * 为VendingMachine选中即将购买的商品，并且将其切换到AfterSelectionState
     *
     * @param productType 产品的type
     */
    @Override
    public void select(ProductType productType) {
        if (!this.vendingMachine.contains(productType)) {
            throw new NotEnoughItemException();
        }
        this.vendingMachine.setSelectedProductType(productType);
        System.out.println(productType.getName() + " is selected.");
        this.vendingMachine.setState(AfterSelectionState.class);
    }

    /**
     * 禁用
     *
     * @param amount 输入的金额
     */
    @Override
    public void pay(Double amount) {
        throw new ItemNotSelectedException();
    }

    /**
     * 禁用
     */
    @Override
    public Product get() {
        throw new ItemNotSelectedException();
    }

    /**
     * 无效
     */
    @Override
    public void cancel() {
    }

    @Override
    public String toString() {
        return "Initial State";
    }
}
