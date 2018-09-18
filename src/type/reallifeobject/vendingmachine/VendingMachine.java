package type.reallifeobject.vendingmachine;

import type.reallifeobject.vendingmachine.exceptions.CannotSelectItemException;
import type.reallifeobject.vendingmachine.state.BeforeSelectionState;
import type.reallifeobject.vendingmachine.state.FinishedPaymentState;
import type.reallifeobject.vendingmachine.state.SelectedItemState;
import type.reallifeobject.vendingmachine.state.State;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private Item selectedItem;
    private State state;
    private Map<Item, Integer> storage;
    private Double insertedValue;

    private BeforeSelectionState beforeSelectionState;
    private SelectedItemState selectedItemState;
    private FinishedPaymentState finishedPaymentState;

    public VendingMachine() {
        this.storage = new HashMap<>();
        /**
         * 各State把调用者作为参数传入Constructor，减少每次调用方法时都传一遍的累赘
         */
        this.beforeSelectionState = new BeforeSelectionState(this);
        this.selectedItemState = new SelectedItemState(this);
        this.finishedPaymentState = new FinishedPaymentState(this);
        this.changeToBeforeSelectionState();
    }

    public void setSelectedItem(Item item) {
        this.selectedItem = item;
    }

    public Item getSelectedItem() {
        return this.selectedItem;
    }

    public void setInsertedValue(Double insertedValue) {
        this.insertedValue = insertedValue;
    }

    public Double getInsertedValue() {
        return this.insertedValue;
    }

    public void selectItem(Item item) {
        this.state.selectItem(item);
    }

    public void pay(Double amount) {
        this.state.pay(amount);
    }

    public Item get() {
        return this.state.get();
    }

    public Integer checkStorage(Item item) {
         if (!this.storage.containsKey(item)) {
             return 0;
         }
         return this.storage.get(item);
    }

    public void refill(Item item, int amount) {
        if (this.storage.containsKey(item)) {
            this.storage.put(item, this.storage.get(item) + amount);
        } else {
            this.storage.put(item, amount);
        }
    }

    public void deductItem(Item item) {
        if (!this.storage.containsKey(item) || this.storage.get(item) < 1) {
            throw new CannotSelectItemException();
        }
        this.storage.put(item, this.storage.get(item) - 1);
    }

    public Double cancel() {
        Double amount = this.insertedValue;
        this.insertedValue = 0.0;

        System.out.println("Cash out for $" + amount);
        return amount;
    }

    public void changeToBeforeSelectionState() {
        /**
         * 更新调用者参数的语句卸载changeToState的函数中
         */
        this.setSelectedItem(null);
        this.setInsertedValue(0.0);

        this.state = this.beforeSelectionState;
    }

    public void changeToSelectedItemState() {
        this.state = this.selectedItemState;
    }

    public void changeToFinishedPaymentState() {
        this.state = this.finishedPaymentState;
    }

    @Override
    public String toString() {
        return "This vending machine has storage " + this.storage.toString();
    }
}
