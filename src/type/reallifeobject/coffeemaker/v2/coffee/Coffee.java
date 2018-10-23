package type.reallifeobject.coffeemaker.v2.coffee;

import java.util.List;

public interface Coffee {
    /**
     * @return 本Coffee的价格
     */
    Double getCost();

    /**
     * @return 本Coffee的所有decorators
     */
    List<String> getCoffeeDecorators();

    /**
     * @return 本Coffee的coffee base
     */
    String getCoffeeBase();

    void printDetail();
}
