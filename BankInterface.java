public interface BankInterface {
    public void addAccount(Account account);

    public Account search(String id);

    public void deposit(String id, Money amount);

    public void withdraw(String id, Money amount);

    public void sortAccounts();
    
    public String toString();

    public int getNumOfAccounts();
}
