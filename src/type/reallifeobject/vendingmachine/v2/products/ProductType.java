package type.reallifeobject.vendingmachine.v2.products;

import type.reservation.hotel.v2.exceptions.InvalidRequestException;

import java.lang.reflect.InvocationTargetException;

public enum  ProductType {
    BOTTLEWATER("Bottle Water", 1.00, BottleWater.class),
    COKE("Coke", 1.25, Coke.class),
    SPRITE("Sprite", 1.25, Sprite.class);

    private String name;
    private double price;
    private Class<? extends Product> productClass;

    ProductType(String name, double price, Class<? extends Product> productClass) {
        this.name = name;
        this.price = price;
        this.productClass = productClass;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * @return a product object based on product type
     */
    public Product getProduct() {
        try {
            return this.productClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        throw new InvalidRequestException("product type is not selected!");
    }
}
