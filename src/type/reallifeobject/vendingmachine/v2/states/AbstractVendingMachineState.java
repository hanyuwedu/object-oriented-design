package type.reallifeobject.vendingmachine.v2.states;

import type.reallifeobject.vendingmachine.v2.VendingMachine;

public abstract class AbstractVendingMachineState implements IVendingMachineState {
    protected VendingMachine vendingMachine;

    protected AbstractVendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
