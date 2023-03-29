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
    public void testWithdrawOutsideOverdraft() {
        Checking checking = new Checking("John Doe", "1234", new Money(100, 0), new Money(50, 0));
        checking.withdraw(new Money(200, 0));
        assertTrue(checking.getBalance().equals(new Money(100, 0)));
    }
}