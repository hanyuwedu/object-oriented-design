package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v2.exceptions.InvalidRequestException;
import type.reallifeobject.vendingmachine.v2.exceptions.NotEnoughItemException;
import type.reallifeobject.vendingmachine.v2.exceptions.PaymentNotSuccessException;
import type.reallifeobject.vendingmachine.v2.VendingMachine;
import type.reallifeobject.vendingmachine.v2.products.Product;

public class AfterSelectionState extends AbstractVendingMachineState{
    public AfterSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    /**
     * 为VendingMachine选中即将购买的商品
     *
     * @param productClass 产品的class type
     */
    @Override
    public void select(Class<? extends Product> productClass) throws Exception {
        if (!this.vendingMachine.contains(productClass)) {
            throw new NotEnoughItemException();
        }
        this.vendingMachine.setSelectProduct(productClass);
        System.out.println(productClass.getDeclaredConstructor().newInstance().getName() + " is selected.");
    }

    /**
     * 更新VendingMachine的付款金额，如果付款金额大于购买商品金额，则切换到AfterPaymentState
     * @param amount 输入的金额
     */
    @Override
    public void pay(Double amount) throws Exception {
        if (amount <= 0) {
            throw new InvalidRequestException("Payment does not go through.");
        }

        this.vendingMachine.setPayment(this.vendingMachine.getPayment() + amount);
        if (this.vendingMachine.getPayment()
                >= this.vendingMachine.getSelectProduct().getDeclaredConstructor().newInstance().getPrice()) {
            this.vendingMachine.setState(AfterPaymentState.class);
        }
    }

    /**
     * 禁用
     *
     * @throws Exception
     */
    @Override
    public Product get() {
        throw new PaymentNotSuccessException();
    }

    /**
     * 取消交易，将售货机的当前信息清空，并将其切换到InitialState
     */
    @Override
    public void cancel() {
        this.vendingMachine.clearRequest();

        System.out.println("Transaction is cancelled.");
        this.vendingMachine.setState(InitialState.class);
    }

    @Override
    public String toString() {
        return "After Selection State";
    }
}
