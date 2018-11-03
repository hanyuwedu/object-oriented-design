package patterns.state;

public class Account {
    Double balance;

    public Account() {
        this.balance = 0.0;
    }

    public void update(Double amount) {
        this.balance += amount;
    }

    public Double getBalance() {
        return this.balance;
    }
}
