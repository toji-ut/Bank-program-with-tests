# Test driven development of an ATM program using JUnit

I worked on implementing an ATM program using JUnit and followed the test-driven development approach. The program consisted of three classes: Money, Account, and Checking, with Bank as the main class.

In the Money class, I defined the attributes dollars and cents and implemented methods to get and manipulate these attributes. I also implemented a method to compare two Money objects.

For the Account class, I used the test-first approach and wrote the test cases before implementing the deposit, withdraw, and transfer methods. The deposit method calls the add method of the Money class, and transfer between accounts is implemented as a deposit to one account and a withdrawal from another.

In the Checking class, which is a subclass of Account, I added an attribute overdraftMaximum and overrode the withdraw method of Account. The new withdraw method checks if the amount to be withdrawn exceeds the balance by more than overdraftMaximum and does not perform the withdrawal if it does. Otherwise, it performs the withdrawal.

In the Bank class, I implemented methods to add a new account, deposit an amount to a given account, and withdraw an amount from a given account using the search method to find the account in the accounts array. The constructor takes in a string representing the name of the bank and initializes the accounts array and the number of accounts.

Overall, I enjoyed working on this program as it allowed me to practice my skills in test-driven development and object-oriented programming.
