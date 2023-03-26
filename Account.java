public class Account {

    private String name;
    private String id;
    private Money balance;

    public Account(String name, String id, Money balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getName()
    {
        return this.name;
    }
    
    public String getId()
    {
        return this.id;
    }
    
    public Money getBalance()
    {
        return this.balance;
    }
    
    public void deposit(Money amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(Money amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void transfer(Account destination, Money amount) {
        this.withdraw(amount);
        destination.deposit(amount);
    }

    public String toString() {
        return this.name + " (" + this.id + "): " + this.balance.toString();
    }

    public boolean equals(Account other) {
        return (this.name.equals(other.name) && this.id.equals(other.id) && this.balance.equals(other.balance));
    }
}
