/**
 * Manage input to be read from either keyboard or file.
 *
 * @version 1.0
 */
import java.util.Scanner;

public class InputManager {
    /**
     * Reads account data from a Scanner object and returns an Account object.
     * Assumes account data is in the format of: id, name, balance, account type (r = regular, c = checking),
     * and overdraft maximum (if account type is checking).
     *
     * @param inputSource a Scanner object set up to read from a text file or standard input source (keyboard).
     * @return an Account object with the data read for one account.
     */
    public static Account readOneAccountFrom(Scanner inputSource) {
        // Read one line of account data into oneLine
        System.out.println("Reading: id, name, balance...");
        String oneLine = inputSource.nextLine();

        // Parse line of account data, separated by commas
        Scanner lineTokenizer = new Scanner(oneLine);
        lineTokenizer.useDelimiter(", ");

        // Get account data (i.e. name, id, balance, accountType, and overdraftMax) from oneLine
        String name = lineTokenizer.next();
        String accountId = lineTokenizer.next();
        int dollars = lineTokenizer.nextInt();
        int cents = lineTokenizer.nextInt();
        Money balance = new Money(dollars, cents);
        String accountType = lineTokenizer.next();
        Money overdraftMax = null;
        if (accountType.equals("c")) {
            dollars = lineTokenizer.nextInt();
            cents = lineTokenizer.nextInt();
            overdraftMax = new Money(dollars, cents);
        }

        // Create and return an Account object with the data read for one account
        if (accountType.equals("r")) {
            Account oneAccount = new Account(name, accountId, balance);
            System.out.println("Account read: " + oneAccount + "\n");
            return oneAccount;
        } else if (accountType.equals("c")) {
            Checking oneAccount = new Checking(name, accountId, balance, overdraftMax);
            System.out.println("Account read: " + oneAccount + "\n");
            return oneAccount;
        } else {
            System.out.println("Invalid account type: " + accountType);
            return null;
        }
    } // end readOneAccountFrom
} // end InputManager
