import java.util.Collections;
import java.util.ArrayList;
public class Bank2 implements BankInterface{

    String nameOfBank;
    private ArrayList<Account> accounts;
    private int numOfAccounts;

    public Bank2(String name) {
        nameOfBank = name;
        accounts = new ArrayList<>();
        numOfAccounts = 0;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        numOfAccounts++;
    }

    public Account search(String id) {
        int index = BinarySearchWithArrayList.binarySearchWithArrayList(accounts, 0, accounts.size()-1, id);
        if (index == -1) {
            return null;
        } else {
            return accounts.get(index);
        }
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
            result.append(accounts.get(i).toString()).append("\n");
        }
        return result.toString();
    }

    public void sortAccounts(){
        Collections.sort(accounts);
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }

    public String getNameOfBank() {
        return nameOfBank;
    }

}
