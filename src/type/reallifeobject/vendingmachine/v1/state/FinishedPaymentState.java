package type.reallifeobject.vendingmachine.v1.state;

import type.reallifeobject.vendingmachine.v1.Item;
import type.reallifeobject.vendingmachine.v1.VendingMachine;
import type.reallifeobject.vendingmachine.v1.exceptions.CannotSelectItemException;

public class FinishedPaymentState implements State {
    private VendingMachine vendingMachine;

    public FinishedPaymentState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectItem(Item item) {
        throw new CannotSelectItemException();
    }

    @Override
    public void pay(Double amount) {
        this.vendingMachine.setInsertedValue(this.vendingMachine.getInsertedValue() + amount);
    }

    @Override
    public Item get() {
        Double cashout = this.vendingMachine.getInsertedValue()
                - this.vendingMachine.getSelectedItem().getPrice();

        System.out.println("Cash out for $" + cashout);

        Item item = this.vendingMachine.getSelectedItem();
        this.vendingMachine.deductItem(item);
        this.vendingMachine.changeToBeforeSelectionState();

        System.out.println("This vending machine provides a " + item.getName());

        return item;
    }
}
