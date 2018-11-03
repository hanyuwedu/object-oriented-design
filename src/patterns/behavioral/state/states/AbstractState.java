package patterns.behavioral.state.states;

import patterns.behavioral.state.ATM;
import patterns.behavioral.state.account.Account;

public abstract class AbstractState {
    protected ATM atm;

    protected AbstractState(ATM atm) {
        this.atm = atm;
    }

    public abstract void printBalance(Account account);
    public abstract void cashOut(Account account, Double amount);
    public abstract void deposit(Account account, Double amount);
}
