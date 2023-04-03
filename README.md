# Test driven development of an ATM program using JUnit


#Money program

Initialized: 
  - dollars : int
  - cents : int

Constructor: 
  + Money (int, int)

Methods: 
  + getDollars() : int
  + getCents() : int
  + add (Money) : Money
  + subtract (Money) : Money
  + toString() : String
  + equals (Money) : boolean
  + compareTo (Money) : int



#Account

AccountTest and Account. Using the test-first approach. Deposit method, calls a helper method, the add method of your Money class. A transfer between accounts is a deposit to one account and a withdrawal to another; 
  - name : String
  - id : String
  - balance : Money

Constructor: 
  + Account (String, String, Money)

Methods: 
  + deposit (Money)
  + withdraw (Money)
  + transfer (Account, Money)
  + toString() : String
  + equals (Account) : boolean


#Checking (subclass of Account)

Checking, which has an attribute overdraftMaximum and overrides the withdraw method of Account so that it checks whether the amount to be withdrawn exceeds the balance by more than overdraftMaximum; if so, it does not perform the withdrawal; otherwise, it performs the withdrawal. For example, if the balance is 100.00, and the account is a regular account (no overdraft protection), then the account holder can withdraw up to 100.00; if the balance is 100.00, and the account has overdraft protection with an overdraft maximum of 50.00, then the account holder can withdraw up to 150.00.

Initialized: 
  - name : String
  - id : String
  - balance : Money

Constructor:
  + Checking (String, String, Money, Money) 

Methods: 
  + withdraw



#Bank

BankTest and Bank. According to the test-first approach, a test case should be written before the code that makes that test pass. 
For the Bank, included operations for adding a new account to its array of accounts, depositing an amount to a given account (according to its id number), and withdrawing an amount from a given account (according to its id number). Given an account id number, the search method should return the account (in the array accounts) that has that id number. The constructor takes in a string representing the name of the bank, allocates storage for the array (each element of which is a reference to an Account object), and initializes the number of accounts to 0.
The deposit and withdraw methods of the Bank use the search method of ADT Bank as a helper method to first find the account to update within the array of accounts; once the account is found, it is then updated via a call to the deposit or withdraw method of the ADT Account.

Initilized
  - nameOfBank : String
  - accounts : Account[]
  - numOfAccounts : int

Constructor:
  + Bank (String)

Methods:
+ addAccount (Account)
+ search (String) : Account 
+ deposit (String, Money)
+ withdraw (String, Money)
+ toString() : String
