package patterns.state;

public interface State {
    void printBalance(Account account);
    void cashOut(Account account, Double amount);
    void deposit(Account account, Double amount);
}
