/**
 * The Account class represents a general bank account.
 * It implements the Comparable interface for comparing accounts based on their IDs.
 */
public class Account implements Comparable{

    private String name;
    private String id;
    private Money balance;

    /**
     * Constructs an Account object with the specified name, ID, and initial balance.
     *
     * @param name    the name associated with the account
     * @param id      the unique ID of the account
     * @param balance the initial balance of the account
     */
    public Account(String name, String id, Money balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    /**
     * Returns the name associated with the account.
     *
     * @return the account name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Returns the unique ID of the account.
     *
     * @return the account ID
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * Returns the current balance of the account.
     *
     * @return the account balance
     */
    public Money getBalance()
    {
        return this.balance;
    }

    /**
     * Deposits the specified amount into the account.
     *
     * @param amount the amount to be deposited
     */
    public void deposit(Money amount) {
        this.balance = this.balance.add(amount);
    }

    /**
     * Withdraws the specified amount from the account.
     *
     * @param amount the amount to be withdrawn
     * @throws InsufficientFundsException if the withdrawal amount exceeds the account balance
     */
    public void withdraw(Money amount) throws InsufficientFundsException {
        this.balance = this.balance.subtract(amount);
    }


    /**
     * Withdraws the specified amount from the account, limited by the account balance.
     * If the account is not a Checking account, the withdrawal is limited by the account balance.
     * If it is a Checking account, the withdrawal follows the Checking account's rules.
     *
     * @param amount the amount to be withdrawn
     * @throws InsufficientFundsException if the withdrawal amount exceeds the account balance
     */

    public void withdrawLimited(Money amount) throws InsufficientFundsException {
        // If the account is not a Checking account, calling the withdraw method on it will execute the withdraw method of the Account class.
        // However, the current withdraw method in the Account class allows any amount to be withdrawn without considering the balance.
        // If you want to limit withdrawals on regular accounts to not exceed the balance, you can create a separate withdraw method in the Account class.
        // This new withdraw method will only allow withdrawal if the amount does not exceed the current balance.
        if (this instanceof Checking checkingAccount) {
            checkingAccount.withdraw(amount);
        } else {
            if (amount.compareTo(this.balance) > 0) {
                throw new InsufficientFundsException("Insufficient funds in account (" + this.id + ").");
            }
            this.balance = this.balance.subtract(amount);
        }
    }

    /**
     * Transfers the specified amount from the current account to the destination account.
     *
     * @param destination the account to transfer the funds to
     * @param amount      the amount to be transferred
     * @throws InsufficientFundsException if the transfer amount exceeds the account balance
     */
    public void transfer(Account destination, Money amount) throws InsufficientFundsException {
        this.withdraw(amount);
        destination.deposit(amount);
    }

    /**
     * Returns a string representation of the account.
     *
     * @return a string representation of the account
     */
    public String toString() {
        return this.name + " (" + this.id + "): " + this.balance.toString();
    }

    /**
     * Checks if the specified account is equal to this account.
     *
     * @param other the account to compare
     * @return true if the accounts are equal, false otherwise
     */
    public boolean equals(Account other) {
        return (this.name.equals(other.name) && this.id.equals(other.id) && this.balance.equals(other.balance));
    }

    /**
     * Compares this account with the specified object for order based on their IDs.
     *
     * @param o the object to be compared
     * @return 0 if this account's ID is the same as the other account's ID,
     *         -1 if this account's ID is less than the other account's ID,
     *         1 if this account's ID is greater than the other account's ID
     * @throws ClassCastException if the object is not an instance of Account
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Account) {
            if (this.id.equals(((Account) o).id)){
                return 0;
            } else if (this.id.compareTo(((Account) o).id) < 0) {
                return -1;
            } else {
                return 1;
            }
        } else {
            throw new ClassCastException("Object is not an instance of Account");
        }
    }

}
