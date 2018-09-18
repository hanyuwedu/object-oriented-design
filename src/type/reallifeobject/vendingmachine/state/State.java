package type.reallifeobject.vendingmachine.state;

import type.reallifeobject.vendingmachine.Item;

public interface State {
    void selectItem(Item item);
    void pay(Double amount);
    Item get();
}
