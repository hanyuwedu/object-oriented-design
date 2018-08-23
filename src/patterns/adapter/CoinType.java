package patterns.adapter;

public enum CoinType {
    PENNY(1.0),
    NICKLE(5.0),
    DIME(10.0),
    QUARTER(50.0);

    private Double value;

    private CoinType(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }
}
