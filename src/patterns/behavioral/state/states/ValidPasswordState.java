package patterns.behavioral.state.states;

import patterns.behavioral.state.ATM;
import patterns.behavioral.state.account.Account;

/// Valid passoword state support all operations
public class ValidPasswordState extends AbstractState {
    public ValidPasswordState(ATM atm) {
        super(atm);
    }

    @Override
    public void printBalance(Account account) {
        System.out.println("Current balance is: " + account.getBalance());
    }

    @Override
    public void cashOut(Account account, Double amount) {
        account.update(-amount);
        System.out.println("Cashed $" + amount);
        this.printBalance(account);
    }

    @Override
    public void deposit(Account account, Double amount) {
        account.update(amount);
        System.out.println("Deposit $" + amount);
        this.printBalance(account);
    }
}
