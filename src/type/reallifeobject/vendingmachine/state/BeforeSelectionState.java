package type.reallifeobject.vendingmachine.state;

import type.reallifeobject.vendingmachine.Item;
import type.reallifeobject.vendingmachine.VendingMachine;
import type.reallifeobject.vendingmachine.exceptions.CannotSelectItemException;
import type.reallifeobject.vendingmachine.exceptions.ItemNotSelectedException;

public class BeforeSelectionState implements State {
    VendingMachine vendingMachine;

    public BeforeSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectItem(Item item) {
        if (this.vendingMachine.checkStorage(item) <= 0) {
            throw new CannotSelectItemException();
        }
        this.vendingMachine.setSelectedItem(item);
        this.vendingMachine.changeToSelectedItemState();
    }

    @Override
    public void pay(Double amount) {
        throw new ItemNotSelectedException();
    }

    @Override
    public Item get() {
        throw new ItemNotSelectedException();
    }
}
