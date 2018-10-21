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

    @Override
    public void select(Class<? extends Product> productClass) throws Exception {
        if (!this.vendingMachine.contains(productClass)) {
            throw new NotEnoughItemException();
        }
        this.vendingMachine.setSelectProduct(productClass);
        System.out.println(productClass.getDeclaredConstructor().newInstance().getName() + " is selected.");
    }

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

    @Override
    public Product get() {
        throw new PaymentNotSuccessException();
    }

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
