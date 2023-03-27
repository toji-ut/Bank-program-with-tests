public class Bank {

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
        String result = "Bank name: " + nameOfBank + "\n";
        for (int i = 0; i < numOfAccounts; i++) {
            result += accounts[i].toString() + "\n";
        }
        return result;
    }



    public int getNumOfAccounts() {
        return numOfAccounts;
    }

}
