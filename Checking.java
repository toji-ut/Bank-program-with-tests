public class Checking extends Account {
    private Money overdraftMaximum;

    public Checking(String name, String id, Money balance, Money overdraftMaximum) {
        super(name, id, balance);
        this.overdraftMaximum = overdraftMaximum;
    }

    public Money getOverdraftMaximum() {
        return overdraftMaximum;
    }

    @Override
    public void withdraw(Money amount) {
        if (getBalance().add(overdraftMaximum).compareTo(amount) >= 0) {
            super.withdraw(amount);
        } else {
            //System.out.println("Withdrawal amount exceeds available balance with overdraft protection.");
            throw new InsufficientFundsException("Withdrawal amount exceeds available balance with overdraft protection.");
        }
    }

    public String toString() {
        return super.toString() + " (Overdraft Max: " + this.overdraftMaximum + ")";
    }
}
