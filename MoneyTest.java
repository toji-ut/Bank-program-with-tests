import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Test the Money class.

public class MoneyTest
{
    private Money _amount;

    /**
     * Default constructor for test class MoneyTest
     */
    public MoneyTest()
    {
        //System.out.println("JUnit Framework calls Constructor of test class before executing test methods");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        _amount = new Money(0, 0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        _amount = null;
    }

    /**
     * Test methods
     */

    // Test creation of Money objects.
    @Test
    public void testCreate()
    {
        assertEquals("Error in testCreate", 0, _amount.getDollars());
        assertEquals("Error in testCreate", 0, _amount.getCents());

        Money amount2 = new Money (4, 50);

        assertEquals("Error in testCreate", 4, amount2.getDollars());
        assertEquals("Error in testCreate", 50, amount2.getCents());

        Money amount3 = new Money (-4, -50);

        assertEquals("Error in testCreate", -4, amount3.getDollars());
        assertEquals("Error in testCreate", -50, amount3.getCents());

    }

    // Test conversion of Money object to String.
    @Test
    public void testToString()
    {
        // First test: cents is two digits
        Money amount = new Money (7, 55);
        String actual = amount.toString();
        String expected = "$7.55";
        assertTrue("Error in testToString", actual.equals(expected));

        // Second test: cents is one digit
        Money amount2 = new Money (7, 5);
        String actual2 = amount2.toString();
        String expected2 = "$7.05";
        assertTrue("Error in testToString", actual2.equals(expected2));
    }

    // Test equality of money values that are the same.
    @Test
    public void testEquality()
    {
        Money myCash = new Money (3, 75);
        Money yourCash = new Money (3, 75);

        assertTrue ("Error in testEquality", myCash.equals(yourCash));

        Money myAmount = new Money (50, 0);
        Money yourAmount = new Money (50, 0);

        assertTrue ("Error in testEquality", myAmount.equals(yourAmount));
    }

    // Test inequality of money values that are different.
    @Test
    public void testInequality()
    {
        Money myCash = new Money (3, 75);
        Money diffDollarsSameCents = new Money (4, 75);
        Money diffDollarsDiffCents = new Money (4, 80);
        Money sameDollarsDiffCents = new Money (3, 80);

        assertFalse ("Error in testInequality", myCash.equals(diffDollarsSameCents));
        assertFalse ("Error in testInequality", myCash.equals(diffDollarsDiffCents));
        assertFalse ("Error in testInequality", myCash.equals(sameDollarsDiffCents));
    }

    // Test addition of money values such that the sum of the cents do not exceed 99.
    @Test
    public void testSimpleAdd()
    {
        Money amount2 = new Money (2, 30);
        Money amount3 = new Money (3, 50);

        Money actualAmount = amount2.add (amount3);
        // actualAmount now has the sum of amount2 + amount 3

        // Expected result is $5.80
        Money expectedAmount = new Money (5, 80);

        assertTrue ("Error in testSimpleAdd", actualAmount.equals(expectedAmount));
    }

    // Test complex addition  of two money values, i.e. sum of cents is greater than or equal to 100.
    @Test
    public void testComplexAdd()
    {
        // First test: sum of cents is 100.

        Money myCash = new Money (3, 50);
        Money yourCash = new Money (4, 50);

        // Expected result is $8.00
        Money expectedAmount = new Money (8, 0);

        Money actualAmount = myCash.add(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testComplexAdd", actualAmount.equals(expectedAmount));

        // Second test: sum of cents is greater than 100...
        
        Money myAmount = new Money(3, 70);
        Money yourAmount = new Money(4, 70);
        
        Money expectedTotal = new Money (8, 40);
        
        Money actualTotal = myAmount.add(yourAmount);
        
        assertTrue("Error in testComplexAdd", actualTotal.equals(expectedTotal));

    }

    @Test
    public void testSubtract()
    {
        Money amount1 = new Money (2, 30);
        Money amount2 = new Money (3, 50);

        Money actualAmount = amount2.subtract (amount1);
     
        Money expectedAmount = new Money (1, 20);

        assertTrue ("Error in testSubsract", actualAmount.equals(expectedAmount));
        
        Money amount3 = new Money (1, 30);
        Money amount4 = new Money (3, 40);

        Money actualAmount1 = amount3.subtract (amount4);
        
        Money expectedAmount2 = new Money (-2, -10);

        assertTrue ("Error in testSubsract", actualAmount1.equals(expectedAmount2));
        
    }
    
    @Test
    public void testCompareTo()
    {
        Money amount1 = new Money(7, 50);
        Money amount2 = new Money(2, 30);
    
        int result = amount1.compareTo(amount2);
        // result is 1 since amount1 is greater than amount2
    
        assertEquals("Error in testCompareTo", 1, result);
    
        Money amount3 = new Money(2, 20);
        Money amount4 = new Money(5, 50);
    
        result = amount3.compareTo(amount4);
        // result is -1 since amount3 is less than amount4
    
        assertEquals("Error in testCompareTo", -1, result);
    
        Money amount5 = new Money(7, 50);
        Money amount6 = new Money(7, 50);
    
        result = amount5.compareTo(amount6);
        // result is 0 since amount5 is equal to amount6
    
        assertEquals("Error in testCompareTo", 0, result);
        

    }
}


