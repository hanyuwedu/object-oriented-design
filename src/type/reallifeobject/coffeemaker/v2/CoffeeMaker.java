package type.reallifeobject.coffeemaker.v2;

import type.reallifeobject.coffeemaker.v2.coffee.Coffee;
import type.reallifeobject.coffeemaker.v2.decorators.WithChocolate;
import type.reallifeobject.coffeemaker.v2.decorators.WithMilk;
import type.reallifeobject.coffeemaker.v2.exceptions.BaseNotSelectedException;

import java.lang.reflect.InvocationTargetException;

public class CoffeeMaker {
    private Coffee coffee;

    public CoffeeMaker() {
        this.coffee = null;
    }

    /**
     * 将当前CoffeeMaker中的Coffee返回。如果没有设置则抛出异常
     *
     * @return 当前正在制作的Coffee
     */
    public Coffee makeCoffee() {
        if (coffee == null) {
            throw new BaseNotSelectedException("Coffee is not selected yet");
        }

        try {
            return coffee;
        } finally {
            this.clear();
        }
    }

    /**
     * 清除正在制作的Coffee
     */
    private void clear() {
        this.coffee = null;
    }

    public void setCoffee(Class<? extends Coffee> coffeeClass)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        this.coffee = coffeeClass.getDeclaredConstructor().newInstance();
    }

    /**
     * 为当前CoffeeMaker导入CoffeePack
     * @param coffeePack 被导入的CoffeePack
     */
    public void importCoffeePack(CoffeePack coffeePack) {
        this.coffee = coffeePack.getCoffeeBase();
        for (int i = 1; i <= coffeePack.neededMilk; i++) {
            this.addMilk();
        }

        for (int j = 1; j <= coffeePack.neededChocolate; j++) {
            this.addChocolate();
        }
    }

    /**
     * 为当前CoffeeMaker中制作的Coffee添加milk
     */
    public void addMilk() {
        if (coffee == null || coffee.getCoffeeBase().isEmpty()) {
            throw new BaseNotSelectedException();
        }
        this.coffee = new WithMilk(this.coffee);
    }

    /**
     * 为当前CoffeeMaker中制作的Coffee添加chocolate
     */
    public void addChocolate() {
        if (coffee.getCoffeeBase() == null || coffee.getCoffeeBase().isEmpty()) {
            throw new BaseNotSelectedException();
        }
        this.coffee = new WithChocolate(this.coffee);
    }
}
