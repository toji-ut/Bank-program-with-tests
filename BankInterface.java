import java.util.ArrayList;

public interface BankInterface {

    /**
     * Adds a new account to the bank.
     * @param account Account to be added to the bank
     */
    public void addAccount(Account account);

    /**
     * Searches an account in the bank by id.
     * @param id Id of the account to be searched
     * @return Account if found, otherwise null
     */
    public Account search(String id);

    /**
     * Deposits an amount to the account with given id.
     * @param id Id of the account to which amount should be deposited
     * @param amount Amount to be deposited
     */
    public void deposit(String id, Money amount);

    /**
     * Withdraws an amount from the account with given id.
     * @param id Id of the account from which amount should be withdrawn
     * @param amount Amount to be withdrawn
     */
    public void withdraw(String id, Money amount);

    /**
     * Sorts the accounts array in ascending order of their account ids.
     */
    public void sortAccounts();

    /**
     * Returns a string representation of the bank.
     * @return String representation of the bank
     */
    public String toString();

    /**
     * Returns number of accounts in the bank.
     * @return Number of accounts in the bank
     */
    public int getNumOfAccounts();

    /**
     * Returns a name of the bank
     * @return name of the bank
     */
    public String getNameOfBank();

}
