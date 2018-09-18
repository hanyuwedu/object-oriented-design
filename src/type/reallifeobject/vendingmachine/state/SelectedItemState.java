package type.reallifeobject.vendingmachine.state;

import type.reallifeobject.vendingmachine.Item;
import type.reallifeobject.vendingmachine.VendingMachine;
import type.reallifeobject.vendingmachine.exceptions.CannotSelectItemException;

public class SelectedItemState implements State {
    private VendingMachine vendingMachine;

    public SelectedItemState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(Item item) {
        if (this.vendingMachine.checkStorage(item) <= 0) {
            throw new CannotSelectItemException();
        }
        this.vendingMachine.setSelectedItem(item);
    }

    @Override
    public void pay(Double amount) {
        this.vendingMachine.setInsertedValue(this.vendingMachine.getInsertedValue() + amount);
        if (this.vendingMachine.getInsertedValue()
                >= this.vendingMachine.getSelectedItem().getPrice()) {
            this.vendingMachine.changeToFinishedPaymentState();
        }
    }

    @Override
    public Item get() {
        System.out.println("The price of this item is $" + this.vendingMachine.getSelectedItem().getPrice());
        System.out.println("You have paid $" + this.vendingMachine.getInsertedValue());
        System.out.println("Please insert the rest of the amount");
        return null;
    }
}
