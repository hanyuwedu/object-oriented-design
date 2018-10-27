package type.reallifeobject.vendingmachine.v2;

import type.reallifeobject.vendingmachine.v2.products.Inventory;
import type.reallifeobject.vendingmachine.v2.products.Product;
import type.reallifeobject.vendingmachine.v2.products.ProductType;
import type.reallifeobject.vendingmachine.v2.states.AfterPaymentState;
import type.reallifeobject.vendingmachine.v2.states.AfterSelectionState;
import type.reallifeobject.vendingmachine.v2.states.IVendingMachineState;
import type.reallifeobject.vendingmachine.v2.states.InitialState;
import type.reservation.hotel.v2.exceptions.InvalidRequestException;

import java.util.List;

public class VendingMachine {
    private Inventory inventory;
    private ProductType selectedProductType;
    private double payment;

    private IVendingMachineState currentState;
    private InitialState initialState;
    private AfterSelectionState afterSelectionState;
    private AfterPaymentState afterPaymentState;

    public VendingMachine(List<ProductType> productTypeList) {
        this.inventory = new Inventory(productTypeList);
        this.initialState = new InitialState(this);
        this.afterSelectionState = new AfterSelectionState(this);
        this.afterPaymentState = new AfterPaymentState(this);

        this.setState(InitialState.class);
    }

    /**
     * 为该vending machine选择产品
     *
     * @param productType 产品的type
     */
    public void select(ProductType productType) {
        this.currentState.select(productType);
    }

    /**
     * 为vending machine输入金额
     *
     * @param amount 输入的金额
     */
    public void pay(Double amount) {
        this.currentState.pay(amount);
    }

    /**
     * 从vending machine中取出产品
     *
     * @return 即将取得的产品
     */
    public Product get() {
        return this.currentState.get();
    }

    /**
     * 取消vending machine正在进行的交易
     */
    public void cancel() {
        this.currentState.cancel();
    }

    public void setState(Class<? extends IVendingMachineState> state) {
        if (state.equals(InitialState.class)) {
            this.currentState = this.initialState;
        } else if (state.equals(AfterSelectionState.class)) {
            this.currentState = this.afterSelectionState;
        } else if (state.equals(AfterPaymentState.class)) {
            this.currentState = this.afterPaymentState;
        } else {
            throw new InvalidRequestException("input state is not valid!");
        }
    }

    /**
     * 为vending machine填充产品数量
     *
     * @param productType 产品的type
     * @param amount refill的数量
     */
    public void refill(ProductType productType, int amount) {
        this.inventory.refill(productType, amount);
    }

    /**
     * 为指定产品减少一个库存
     *
     * @param productType 产品的type
     */
    public void reduce(ProductType productType) {
        this.inventory.reduce(productType);
    }


    /**
     * 取消当前vending machine的一切交易，切回原始状态
     */
    public void clearRequest() {
        if (this.getPayment() != 0) {
            System.out.println("$" + this.getPayment() + " will be refunded.");
        }
        this.setPayment(0);
        this.setSelectedProductType(null);
    }

    /**
     * 查看指定产品是否有库存
     *
     * @param productType 产品的type
     * @return 指定产品是否有库存
     */
    public boolean contains(ProductType productType) {
        return this.inventory.contains(productType);
    }

    public ProductType getSelectedProductType() {
        return selectedProductType;
    }

    public double getPayment() {
        return payment;
    }

    public void setSelectedProductType(ProductType selectedProductType) {
        this.selectedProductType = selectedProductType;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public void printInfo() {
        System.out.println("Current State: " + this.currentState);
        if (this.selectedProductType != null) {
            System.out.println("Selected product: " + this.selectedProductType.getName());
        }
        System.out.println("Inserted Balance: " + this.getPayment());
        System.out.println("Inventory: " + this.inventory.toString());
    }
}
