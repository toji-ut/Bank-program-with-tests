import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

// Driver class for Bank project

public class ATM {
    public static void main(String[] args) {
        try {

            // Read data from a file into a Bank.
            // Each line of the file has info for one account.
            BankInterface bank = readFromFile("accounts_list.txt");

            // Print all the data stored in the bank.
            System.out.println(bank);

            IOHandlerInterface ioh = new IOHandlerStandard();
            // Read user input.
            String id = readUserID(ioh);
            // Echo user input.
            ioh.put("You entered " + id);

            if (isValid(bank, id)) {
                System.out.println("Account FOUND for ID: " + id);
            } else {
                System.out.println("Account NOT FOUND for ID: " + id);
            }
        } // end try
        catch (IOException ioe) {
            System.out.println("IOException in main: " + ioe.getMessage());
            ioe.printStackTrace();
        } // end catch
        catch (Exception e) {
            System.out.println("Exception in main: " + e.getMessage());
            e.printStackTrace();
        } // end catch

    } // end main

    /**
     * readFromFile: Read the accounts from a text file
     */
    public static BankInterface readFromFile(String fileName) throws IOException {
        // Create a bank.
        BankInterface bank = new Bank2("Bank of Kazakhstan");
        // Open a file for reading.
        Scanner inputSource = new Scanner(new File(fileName));

        // while there are more tokens to read from the input source...
        // **** INSERT CODE FOR BOOLEAN EXPRESSION: THERE IS MORE TO READ FROM THE INPUT SOURCE i.e. call hasNext() method on Scanner object ****
        while (inputSource.hasNext()) {

            // Read one line of input from the file into an Account object
            Account account = InputManager.readOneAccountFrom(inputSource);

            // Store the account info in the bank.
            // **** INSERT CODE TO ADD acct TO THE BANK ****
            bank.addAccount(account);

        } // end while


        return bank;

    } // end readFromFile

    /**
     * readUserID:
     *
     * @param IOHandlerInterface ioh
     * @return String id read from user.
     */
    public static String readUserID(IOHandlerInterface ioh) {
        return ioh.get("Please enter your ID: ");
    }

    public static boolean isValid(BankInterface bank, String id) {
        return bank.search(id) != null;
    } // end ATM
}