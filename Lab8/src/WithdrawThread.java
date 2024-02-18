/**
 * Class implementing the Runnable interface for withdrawing money from a bank account - without thread synchronization.
 */
public class WithdrawThread implements Runnable {
    private SharedBank bank;
    private int withdrawalAmount;

    /**
     * Constructor accepting two parameters.
     * @param bank the bank account
     * @param withdrawalAmount the amount of money to withdraw
     */
    public WithdrawThread(SharedBank bank, int withdrawalAmount) {
        this.bank = bank;
        this.withdrawalAmount = withdrawalAmount;
    }

    /**
     * Method responsible for executing the thread.
     */
    @Override
    public void run() {
        getBank().withdraw(getWithdrawalAmount());
        System.out.println("The remaining balance in the account is: " + getBank().getBalance() + " zł ");
    }

    /**
     * Method returning the specified amount to withdraw.
     * @return the amount of money to withdraw
     */
    public int getWithdrawalAmount() {
        return withdrawalAmount;
    }

    /**
     * Method setting a new amount to withdraw.
     * @param withdrawalAmount the new amount of money to withdraw
     * @throws IllegalArgumentException when withdrawalAmount <= 0
     */
    public void setWithdrawalAmount(int withdrawalAmount) {
        if (withdrawalAmount <= 0) {
            throw new IllegalArgumentException("The provided amount must be positive.");
        }
        else {
            this.withdrawalAmount = withdrawalAmount;
        }
    }

    /**
     * Method returning the bank account.
     * @return the bank account
     */
    public SharedBank getBank() {
        return bank;
    }

    /**
     * Method setting a new bank account.
     * @param bank the new bank account
     */
    public void setBank(SharedBank bank) {
        this.bank = bank;
    }
}

