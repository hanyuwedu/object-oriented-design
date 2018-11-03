package patterns.behavioral.state;

import patterns.behavioral.state.account.Account;
import patterns.behavioral.state.states.*;

public class ATM {
    private AbstractState currentState;
    private Account account;

    /// Initialize all states in field:
    private InitialState initialState;
    private InsertCardState insertCardState;
    private ValidPasswordState validPasswordState;

    public ATM() {
        /// Initialize a copy of all states:
        this.initialState = new InitialState(this);
        this.insertCardState = new InsertCardState(this);
        this.validPasswordState = new ValidPasswordState(this);
        this.currentState = this.initialState;
    }

    /// State changing methods:
    public void changeState(Class<? extends AbstractState> stateClass) {
        if (stateClass.equals(InitialState.class)) {
            this.currentState = this.initialState;
        } else if (stateClass.equals(InsertCardState.class)) {
            this.currentState = this.insertCardState;
        } else if (stateClass.equals(ValidPasswordState.class)) {
            this.currentState = this.validPasswordState;
        }
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void printBalance() {
        this.currentState.printBalance(account);
    }

    public void cashOut(Double amount) {
        this.currentState.cashOut(account, amount);
    }

    public void deposit(Double amount) {
        this.currentState.deposit(account, amount);
    }
}
