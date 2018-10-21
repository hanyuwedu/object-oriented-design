package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v2.products.Product;

public interface IVendingMachineState {
    void select(Class<? extends Product> productClass) throws Exception;
    void pay(Double amount) throws Exception;
    Product get() throws Exception;
    void cancel();
}
