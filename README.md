# Test driven development of a Bank program using JUnit

I worked on implementing a Bank program using Test Driven Development approach using JUnit. The program consists of 4 concrete classes, Money class, Account class, Checking class, SortClass class, and Bank class with complimentary test classes. Also an interface BankInterface.

In the Money class, I defined the attributes dollars and cents and implemented methods to get and manipulate these attributes. I also implemented a method to compare two Money objects.

For the Account class, I used the test-first approach and wrote the test cases before implementing the deposit, withdraw, and transfer methods. The deposit method calls the add method of the Money class, and transfer between accounts is implemented as a deposit to one account and a withdrawal from another.

In the Checking class, which is a subclass of Account, I added an attribute overdraftMaximum and overrode the withdraw method of Account. The new withdraw method checks if the amount to be withdrawn exceeds the balance by more than overdraftMaximum and does not perform the withdrawal if it does. Otherwise, it performs the withdrawal.

In the Bank class, I implemented methods to add a new account, deposit an amount to a given account, and withdraw an amount from a given account using the search method to find the account in the accounts array. The constructor takes in a string representing the name of the bank and initializes the accounts array and the number of accounts.

The BankInterface is defined with comments and headers for each public method. The header of the concrete Bank class is modified to say "public class Bank implements BankInterface { ... }." The existing tests in BankTest are compiled and run, and they work as before.

A sortAccounts method is defined and tested in the Bank class. This method calls one of the sorting methods of SortsClass.java, which expects an array of type Comparable as a parameter. Since the Bank class will be sorting an array of Account objects, the Account class must implement the Comparable interface (public class Account implements Comparable) which is predefined and override the compareTo method in the Account class. The compareTo method compares two Account objects and returns 0 if this.id is the same as o.id, -1 if this.id < o.id, and 1 if this.id > o.id. The precondition for the compareTo method is that the parameter o is an Object of type Account, and the postcondition is that it returns a value indicating the comparison result.

Overall, I enjoyed working on this project as it allowed me to practice my skills in test-driven development and object-oriented programming.
