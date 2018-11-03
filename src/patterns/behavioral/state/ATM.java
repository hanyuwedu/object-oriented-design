package patterns.state;

public class ATM {
    private State currentState;
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
    public void changeToInitializeState() {
        this.currentState = this.initialState;
    }

    public void changeToInsertCardState() {
        this.currentState = this.insertCardState;
    }

    public void changeToValidPasswordState() {
        this.currentState = this.validPasswordState;
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
