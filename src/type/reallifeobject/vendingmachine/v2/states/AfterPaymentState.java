package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v2.exceptions.CannotSelectItemException;
import type.reallifeobject.vendingmachine.v2.VendingMachine;
import type.reallifeobject.vendingmachine.v2.exceptions.InvalidRequestException;
import type.reallifeobject.vendingmachine.v2.products.Product;

public class AfterPaymentState extends AbstractVendingMachineState{
    public AfterPaymentState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void select(Class<? extends Product> productClass) {
        throw new CannotSelectItemException("Payment has been gone through. Please cancel the transaction first.");
    }

    @Override
    public void pay(Double amount) {
        throw new InvalidRequestException("Payment has already filled.");
    }

    @Override
    public Product get() throws Exception {
        Product product = this.vendingMachine.getSelectProduct().getDeclaredConstructor().newInstance();
        this.vendingMachine.setPayment(this.vendingMachine.getPayment() - product.getPrice());

        /*
         * 是一种好的写法吗？
         */
        try {
            return product;
        } finally {
            this.vendingMachine.clearRequest();
            this.vendingMachine.reduce(product.getClass());
            this.vendingMachine.setState(InitialState.class);
        }

//        this.vendingMachine.clearRequest();
//        this.vendingMachine.reduce(product.getClass());
//        this.vendingMachine.setState(InitialState.class);
//        return product;
    }

    @Override
    public void cancel() {
        this.vendingMachine.clearRequest();

        System.out.println("Transaction is cancelled.");
        this.vendingMachine.setState(InitialState.class);
    }

    @Override
    public String toString() {
        return "After Payment State";
    }
}
