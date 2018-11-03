package patterns.state;

import java.util.Random;

/// Insert card state support deposit operation
public class InsertCardState implements State {
    /// The constructor needs a caller class in the field to change state
    private ATM atm;

    /// For test convenience
    private static int trial = 0;

    public InsertCardState(ATM atm) {
        this.atm = atm;
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
            this.atm.changeToValidPasswordState();
            return true;
        } else {
            trial++;
            System.out.println("Password is invalid!");
            return false;
        }
    }
}
