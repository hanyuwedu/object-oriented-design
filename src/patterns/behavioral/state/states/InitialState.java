package patterns.behavioral.state.states;

import patterns.behavioral.state.ATM;
import patterns.behavioral.state.account.Account;

/// Initial state can not process any request
public class InitialState extends AbstractState {
    /// For test convenience
    private static int trial = 0;

    public InitialState(ATM atm) {
        super(atm);
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
            this.atm.changeState(InsertCardState.class);
            return true;
        } else {
            trial++;
            System.out.println("Card is invalid!");
            return false;
        }
    }
}
