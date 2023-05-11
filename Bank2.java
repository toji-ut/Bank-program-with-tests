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
        int index = binarySearchWithArrayList(accounts, 0, accounts.size()-1, id);
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

    public int binarySearchWithArrayList(ArrayList<Account> anArray, int first, int last, String value) {

    // Searches the array items anArray[first] through
    // anArray[last] for value by using a binary search.
    // Precondition: 0 <= first, last <= SIZE-1, where
    // SIZE is the maximum size of the array, and
    // anArray[first] <= anArray[first+1] <= ... <= anArray[last].
    // Postcondition: If value is in the array, the method
    // returns the index of the array item that equals value;
    // otherwise the method returns -1.

        int index;

        if (first > last) {

            index = -1;      // value not in original array

        }
        else {

            // Invariant: If value is in anArray,
            // anArray[first] <= value <= anArray[last]

            int mid = (first + last)/2;

            if (value.equals(anArray.get(mid).getId())) {

                index = mid;  // value found at anArray[mid]

            }
            else if (value.compareTo(anArray.get(mid).getId()) < 0) {

                index = binarySearchWithArrayList(anArray, first, mid-1, value);   // point X

            }
            else {

                index = binarySearchWithArrayList(anArray, mid+1, last, value);    // point Y

            }  // end if
        }  // end if

        return index;
    }  // end binarySearch
}
