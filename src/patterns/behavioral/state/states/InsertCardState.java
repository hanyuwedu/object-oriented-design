package patterns.behavioral.state.states;

import patterns.behavioral.state.ATM;
import patterns.behavioral.state.account.Account;

/// Insert card state support deposit operation
public class InsertCardState extends AbstractState {
    private static int trial = 0;

    public InsertCardState(ATM atm) {
        super(atm);
    }

    @Override
    public void printBalance(Account account) {
        System.out.println("Cannot retrieve balance! Please Insert Card!");
        if (this.inputPassword()) {
            System.out.println("Password is valid!");
        }
    }

    @Override
    public void cashOut(Account account, Double amount) {
        System.out.println("Cannot cash out! Please Insert Card!");
        if (this.inputPassword()) {
            System.out.println("Password is valid!");
        }
    }

    @Override
    public void deposit(Account account, Double amount) {
        account.update(amount);
        System.out.println("Deposite $" + amount);
    }

    public boolean inputPassword() {
        if (trial >= 2) {
            /// Change state after a milestone operation
            this.atm.changeState(ValidPasswordState.class);
            return true;
        } else {
            trial++;
            System.out.println("Password is invalid!");
            return false;
        }
    }
}
