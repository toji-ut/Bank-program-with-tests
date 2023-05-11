# Test driven development of a Bank program using JUnit

To begin with, I implemented a Bank program using Test Driven Development approach using JUnit. The program consists of 4 concrete classes, namely Money class, Account class, Checking class, SortClass class, and Bank class with complimentary test classes. I also created an interface BankInterface to define the comments and signatures of the methods.

In the Money class, I defined the attributes dollars and cents and implemented methods to get and manipulate these attributes. Additionally, I implemented a method to compare two Money objects.

For the Account class, I used the test-first approach and wrote the test cases before implementing the deposit, withdraw, and transfer methods. The deposit method calls the add method of the Money class, and transfer between accounts is implemented as a deposit to one account and a withdrawal from another.

To introduce overdraft protection, I created a subclass of Account called Checking. This subclass includes a new attribute called overdraftMaximum, which sets the maximum amount that an account holder can withdraw beyond their current balance. To enforce this limit, I overrode the withdraw method of the Account class. When a withdrawal is requested, the new withdraw method checks if the amount to be withdrawn exceeds the balance by more than the overdraftMaximum. If the withdrawal amount is within the limit, it is processed as usual. However, if the withdrawal amount exceeds the overdraftMaximum, the method throws an exception called InsufficientFundsException and does not perform the withdrawal.

In the Bank class, I implemented methods to add a new account, deposit an amount to a given account, and withdraw an amount from a given account using the search method to find the account in the accounts array. The constructor takes in a string representing the name of the bank and initializes the accounts array and the number of accounts.

In the updated version of the bank "Bank2" class, I implemented the same methods, however, instead of using an array, I used an ArrayList. The constructor takes in a string representing the name of the bank and initializes the accounts array-list and the number of accounts.

I have completed the main part of the project, which involved designing and implementing a bank ATM driver class with methods for reading account information into a Bank object from a file, asking the user to login by entering id, validating the id, asking the user to enter a transaction, validating the transaction, executing the transaction, and writing all account information in sorted ascending order of account ids to an output file. To prompt the user for input, I utilized both dialog boxes and standard input.

To ensure the stability of the application, I have also handled exceptions appropriately. In the event that an exception is thrown, the program will not crash. Instead, the exception will be caught and the account will remain unchanged while the user receives a message indicating the error.

To run the program, either download the whole project from Github and run the ATM main class, or alternatively you may run the jar file. 
Make sure that you have downloaded the account_list.txt and output_list.txt before running the jar file.

Upon running the program, the choice you will receive is to enter you ID or quit. Since we do not have a database, we use an account_list.txt file as our database of accounts. I made a 100 random accounts using ChatGPT by prompting it to generate 100 accounts in a specific format (FirstName LastName, id number, balance (dollars), balance (cents), regular/checking account, (if checking), overdraft maximum). For example: Olivia Jones, 45821, 4021, 53, r or Nadia Khan, 87236, 100, 00, c, 50, 00.

Then when the ATM class is ran, it reads the file and adds all of the accounts into an ArrayList of Accounts. When the user enters their ID, it is validated that it exists, and then user gets a choice of three transactions (if ID doesn't exist, the error message appears and check balance (1) / deposit (2) / withdraw (3) / quit (4). Checking balance simply prints out your balance, depositing and withdrawing will prompt the user for an amount and the transaction will go through accordingly, and quitting thanks the user and exits the program. 

Thank you for taking the time to read about my project. I hope you found it informative and interesting.
