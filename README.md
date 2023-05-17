# Test driven development of a Bank program using JUnit

Test-driven development (TDD) is an approach that involves writing tests before implementing the code. It helps ensure that the code meets the desired requirements and behaves as expected. In the context of a Bank program, TDD can be used to develop and test the functionality of various classes and methods.

In my Bank program, I followed the TDD approach using JUnit. I started by creating an interface called BankInterface, which defines the comments and method signatures that the Bank class should implement. This interface helps achieve abstraction and provides a clear definition of the Bank ADT (Abstract Data Type).

The Bank class stores accounts in an array and implements the methods specified in the BankInterface. These methods include adding a new account, depositing an amount to a given account, and withdrawing an amount from a given account. To find the account in the array, the Bank class uses a search method.

The Account class represents a bank account and includes methods for depositing, withdrawing, and transferring funds. The Account class also has attributes such as balance and account ID.

To introduce overdraft protection, I created a subclass of Account called Checking. The Checking class includes an additional attribute called overdraftMaximum, which sets the maximum amount that an account holder can withdraw beyond their current balance. To enforce this limit, I overrode the withdraw method of the Account class in the Checking class. The new withdraw method checks if the withdrawal amount exceeds the balance by more than the overdraftMaximum and throws an exception called InsufficientFundsException if it does.

Additionally, I implemented a SortClass class that provides sorting functionality. The Bank class calls the sortAccounts method from the SortClass to sort the accounts in ascending order based on account IDs. This abstraction allows the main class (ATM) to focus on using the sortAccounts method without needing to know the internal details of the sorting algorithm used (e.g., quickSort).

In the ATM main class, the program reads account information from a file (account_list.txt) and creates a Bank object. It prompts the user to enter their ID and validates it against the accounts in the Bank object. If the ID is valid, the user is presented with options for transactions such as checking the balance, depositing, and withdrawing funds. The ATM class interacts with the Bank object to execute these transactions.

The program handles exceptions appropriately to ensure stability. If an exception is thrown, it is caught, and the account remains unchanged while the user receives an error message indicating the issue.

To improve the efficiency of account management, I created an updated version of the Bank class called Bank2. In Bank2, I replaced the array implementation with an ArrayList to store the accounts. This change provides more flexibility and simplifies certain operations, such as adding and removing accounts.

To run the program, you can download the whole project from GitHub and run the ATM main class. Alternatively, you can run the provided jar file. Make sure to have the account_list.txt and output_list.txt files downloaded before running the program.

I hope you find this project informative and interesting. By following the TDD approach and leveraging abstraction through interfaces, the Bank program achieves modularity and maintainability. It separates the concerns of different classes and provides a clear structure for implementing and testing the functionality of a bank system.
