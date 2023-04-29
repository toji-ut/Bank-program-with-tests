public class Bank implements BankInterface{

    String nameOfBank;
    private Account[] accounts;
    private int numOfAccounts;

    public Bank(String name) {
        nameOfBank = name;
        accounts = new Account[100];
        numOfAccounts = 0;
    }

    public void addAccount(Account account) {
        accounts[numOfAccounts] = account;
        numOfAccounts++;
    }

    public Account search(String id) {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accounts[i].getId().equals(id)) {
                return accounts[i];
            }
        }
        return null;
    }

    public void deposit(String id, Money amount) {
        Account account = search(id);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(String id, Money amount) {
        Account account = search(id);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Bank name: " + nameOfBank + "\n");
        for (int i = 0; i < numOfAccounts; i++) {
            result.append(accounts[i].toString()).append("\n");
        }
        return result.toString();
    }

    public void sortAccounts(){
        SortsClass.selectionSort(accounts, numOfAccounts);
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public String getNameOfBank() {
        return null;
    }

}
