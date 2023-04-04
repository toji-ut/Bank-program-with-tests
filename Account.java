public class Account implements Comparable{

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

    // compareTo: compare two Account objects.
    // Precondition: parameter o is an Object (of type Account)
    // Postcondition: return 0 if this.id is the same as o.id, -1 if this.id < o.id, 1 if this.id > o.id.
    @Override
    public int compareTo(Object o) {
        if (o instanceof Account) {
            if (this.id.equals(((Account) o).id)){
                return 0;
            } else if (this.id.compareTo(((Account) o).id) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
        else {
            throw new ClassCastException("Object is not an instance of Account");
        }
    }

}
