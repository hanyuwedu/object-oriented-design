package patterns.state;

public class Guest {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Account account = new Account();

        /// Before inset card
        atm.printBalance();
        atm.setAccount(account);
        atm.printBalance();
        atm.printBalance();

        /// Insert card
        atm.deposit(100.0);
        atm.printBalance();
        atm.printBalance();
        atm.printBalance();

        /// Input valid password:
        atm.printBalance();
        atm.deposit(300.0);
        atm.cashOut(40.0);
    }
}
