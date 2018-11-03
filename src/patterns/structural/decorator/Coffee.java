package patterns.decorator;

import java.util.List;

public abstract class Coffee {
    /// Abstract class comes with no fields

    public abstract Double getPrice();

    public abstract String getName();

    public abstract List<String> getIngredient();
}
