/**
 * Class creating objects representing bank accounts.
 */
public class SharedBank {
    private int accountBalance;

    /**
     * Constructor accepting one parameter.
     * @param accountBalance the amount of money in the account
     * @throws IllegalArgumentException when accountBalance < 0
     */
    public SharedBank(int accountBalance) {
        if (accountBalance < 0) {
            throw new IllegalArgumentException("Invalid amount of money in the account.");
        }
        else {
            this.accountBalance = accountBalance;
        }
    }

    /**
     * Method withdrawing the specified amount from the account.
     * @param amount the requested amount
     * @throws IllegalArgumentException when amount > currentBalance
     */
    public void withdraw(int amount) {
        int currentBalance = getBalance();
        if (amount <= currentBalance) {
            setBalance(currentBalance - amount);
            System.out.println("Withdrawn from account: " + amount + " zł");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("Insufficient funds in the account.");
        }
    }

    /**
     * Method returning the current account balance.
     * @return the account balance
     */
    public int getBalance() {
        return accountBalance;
    }

    /**
     * Method setting a new account balance.
     * @param accountBalance the new account balance
     * @throws IllegalArgumentException when accountBalance < 0
     */
    public void setBalance(int accountBalance) {
        if (accountBalance < 0) {
            throw new IllegalArgumentException("The provided amount cannot be negative.");
        }
        else {
            this.accountBalance = accountBalance;
        }
    }
}
