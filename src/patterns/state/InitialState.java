package patterns.state;

import java.util.Random;

/// Initial state can not process any request
public class InitialState implements State {
    /// The constructor needs a caller class in the field to change state
    private ATM atm;

    /// For test convenience
    private static int trial = 0;

    public InitialState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void printBalance(Account account) {
        System.out.println("Cannot retrieve balance! Please Insert Card!");
        if (insertCard(account)) {
            System.out.println("Account is setup!");
        }
    }

    @Override
    public void cashOut(Account account, Double amount) {
        System.out.println("Cannot cash out! Please Insert Card!");
        if (insertCard(account)) {
            System.out.println("Account is setup!");
        }
    }

    @Override
    public void deposit(Account account, Double amount) {
        System.out.println("Cannot deposit! Please Insert Card!");
        if (insertCard(account)) {
            System.out.println("Account is setup!");
        }
    }

    public boolean insertCard(Account account) {
        if (trial >= 2) {
            this.atm.setAccount(account);

            /// Change state after a milestone operation
            this.atm.changeToInsertCardState();
            return true;
        } else {
            trial++;
            System.out.println("Card is invalid!");
            return false;
        }
    }
}
