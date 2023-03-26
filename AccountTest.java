import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testConstructor() {
        Money balance = new Money(100, 50);
        Account account = new Account("John", "1234", balance);
        assertEquals("John", account.getName());
        assertEquals("1234", account.getId());
        assertEquals(balance, account.getBalance());
    }

    @Test
    public void testDeposit() {
        Account account = new Account("John", "1234", new Money(100, 50));
        account.deposit(new Money(50, 0));
        //assertEquals(new Money(150, 50), account.getBalance());
        assertTrue(account.getBalance().equals(new Money(150, 50)));
    }

    @Test
    public void testWithdraw() {
        Account account = new Account("John", "1234", new Money(100, 50));
        account.withdraw(new Money(50, 0));
        //assertEquals(new Money(50, 50), account.getBalance());
        assertTrue(account.getBalance().equals(new Money(50, 50)));
    }

    @Test
    public void testTransfer() {
        Account account1 = new Account("John", "1234", new Money(100, 0));
        Account account2 = new Account("Jane", "5678", new Money(50, 0));
        account1.transfer(account2, new Money(25, 0));
        //assertEquals(new Money(75, 0), account1.getBalance());
        //assertEquals(new Money(75, 0), account2.getBalance());
        assertTrue(account1.getBalance().equals(new Money (75, 0)));
    }

    @Test
    public void testToString() {
        Account account = new Account("John", "1234", new Money(100, 50));
        assertEquals("John (1234): $100.50", account.toString());
    }

    @Test
    public void testEquals() {
        Account account1 = new Account("John", "1234", new Money(100, 50));
        Account account2 = new Account("John", "1234", new Money(100, 50));
        assertTrue(account1.equals(account2));
    }
}
