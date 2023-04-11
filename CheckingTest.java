import org.junit.Test;
import static org.junit.Assert.*;

public class CheckingTest {

    @Test
    public void testWithdrawNormal() {
        Checking checking = new Checking("John Doe", "1234", new Money(100, 0), new Money(50, 0));
        checking.withdraw(new Money(50, 0));
        assertTrue(checking.getBalance().equals(new Money(50, 0)));
    }

    @Test
    public void testWithdrawWithinOverdraft() {
        Checking checking = new Checking("John Doe", "1234", new Money(100, 0), new Money(50, 0));
        checking.withdraw(new Money(150, 0));
        assertTrue(checking.getBalance().equals(new Money(-50, 0)));
    }

    @Test
    public void testOverWithdraw() {
        // Create a checking account.
        Checking checking = new Checking("John Doe", "1234", new Money(100, 0), new Money(50, 0));

        try {
            // Withdraw an amount that should cause an exception of type InsufficientFundsException...
            checking.withdraw( new Money(200, 0) );

            // If we reach this point in the code, that means the exception was not thrown as expected, so this test case fails.
            fail();
        }
        catch (InsufficientFundsException ife) {
            System.out.println("InsufficientFunds Exception on testOverWithdraw");
            ife.printStackTrace();
        }

    }


}
