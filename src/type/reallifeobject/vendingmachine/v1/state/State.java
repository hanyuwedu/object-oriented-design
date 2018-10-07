package type.reallifeobject.vendingmachine.v1.state;

import type.reallifeobject.vendingmachine.v1.Item;

public interface State {
    void selectItem(Item item);
    void pay(Double amount);
    Item get();
}
