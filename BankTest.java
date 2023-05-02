import static org.junit.Assert.*;
import org.junit.Test;

public class BankTest {

    @Test
    public void testBankConstructor() {
        Bank bank = new Bank("Wells Fargo");
        //String expectedName = "Wells Fargo";
        String actualName = bank.nameOfBank;
        //int expectedNumOfAccounts = 0;
        int actualNumOfAccounts = bank.getNumOfAccounts();
        assertEquals("Wells Fargo", actualName);
        assertEquals(0, actualNumOfAccounts);
    }
    
    @Test
    public void testAddAccount() {
        Bank bank = new Bank("Bank of America");
        Account account = new Account("John Smith", "12345", new Money(100, 0));
        bank.addAccount(account);
        Account actual = bank.search("12345");
        assertEquals(account, actual);
    }

    @Test
    public void testSearch() {
        Bank bank = new Bank("Bank of Kazakhstan");
        Account account1 = new Account("Mary", "67890", new Money(200, 0));
        bank.addAccount(account1);
        assertEquals(account1, bank.search("67890"));
        assertNull(bank.search("54324"));

    }

    @Test
    public void testDeposit() {
        Bank bank = new Bank("Bank of Kazakhstan");
        Account account = new Account("John", "12345", new Money(100, 0));
        bank.addAccount(account);
        bank.deposit("12345", new Money(50, 0));
        //assertEquals(new Money(150, 0), account.getBalance());
        assertTrue(account.getBalance().equals(new Money(150, 0)));
    }

    @Test
    public void testWithdraw() {
        Bank bank = new Bank("Bank of Kazakhstan");
        Account account = new Account("John", "12345", new Money(100, 0));
        bank.addAccount(account);
        bank.withdraw("12345", new Money(50, 0));
        //assertEquals(new Money(50, 0), account.getBalance());
        assertTrue(account.getBalance().equals(new Money(50, 0)));
    }

    @Test
    public void testSortAccounts() {
        Bank bank = new Bank("Bank of Kazakhstan");
        bank.addAccount(new Account("Elias Ryker", "229", new Money(1735, 0)));
        bank.addAccount(new Account("Bob Smith", "789", new Money(75, 90)));
        bank.addAccount(new Account("John Doe", "123", new Money(100, 50)));
        bank.addAccount(new Checking("Jane Doe", "456", new Money(50, 70), new Money(100, 50)));
        bank.sortAccounts();
        String expected = """
                Bank name: Bank of Kazakhstan
                John Doe (123): $100.50
                Elias Ryker (229): $1735.00
                Jane Doe (456): $50.70
                Bob Smith (789): $75.90
                """;
        assertEquals(expected, bank.toString());
    }
    @Test
    public void testToString() {
        Bank bank = new Bank("Bank of Kazakhstan");
        Account account1 = new Account("Alice", "001", new Money(100, 0));
        Account account2 = new Account("Bob", "002", new Money(50, 50));
        bank.addAccount(account1);
        bank.addAccount(account2);
        String expected = """
                Bank name: Bank of Kazakhstan
                Alice (001): $100.00
                Bob (002): $50.50
                """;
        assertEquals(expected, bank.toString());
    }
}
