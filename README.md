# Test driven development of a Bank program using JUnit

Hello there! I am pleased to present to you my project for CSC 175 Intermediate Programming in Spring 2023. For this project, I had to build upon my knowledge and experience from previous lab exercises and examples of Dialog Boxes and File I/O.

To begin with, I implemented a Bank program using Test Driven Development approach using JUnit. The program consists of 4 concrete classes, namely Money class, Account class, Checking class, SortClass class, and Bank class with complimentary test classes. I also created an interface BankInterface to define the comments and signatures of the methods.

In the Money class, I defined the attributes dollars and cents and implemented methods to get and manipulate these attributes. Additionally, I implemented a method to compare two Money objects.

For the Account class, I used the test-first approach and wrote the test cases before implementing the deposit, withdraw, and transfer methods. The deposit method calls the add method of the Money class, and transfer between accounts is implemented as a deposit to one account and a withdrawal from another.

In the Checking class, which is a subclass of Account, I added an attribute overdraftMaximum and overrode the withdraw method of Account. The new withdraw method checks if the amount to be withdrawn exceeds the balance by more than overdraftMaximum and does not perform the withdrawal if it does. Otherwise, it performs the withdrawal.

In the Bank class, I implemented methods to add a new account, deposit an amount to a given account, and withdraw an amount from a given account using the search method to find the account in the accounts array. The constructor takes in a string representing the name of the bank and initializes the accounts array and the number of accounts.

Moving forward, the main part of the project was to design and implement a bank ATM driver class with methods for reading account information into a Bank object from a file, asking the user to login by entering id, validating id, asking the user to enter a transaction, validating the transaction, executing the transaction, and writing all account information in sorted ascending order of account ids to an output file. I used dialog boxes and standard input for asking the user to login and enter a transaction.

Once the above was working, I incorporated overdraft protection by introducing a subclass of Account called Checking, which has an instance variable overdraftMaximum and overrides the withdraw method of Account so that it checks whether the amount to be withdrawn exceeds the balance by more than overdraftMaximum. If so, it throws an exception: InsufficientFundsException; otherwise, it performs the withdrawal.

Finally, I ensured that the application does not crash upon an exception being thrown; rather it should be caught and handled appropriately (i.e. no change to the account and a message to the user).

Thank you for taking the time to read about my project. I hope you found it informative and interesting.
