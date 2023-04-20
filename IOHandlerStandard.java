import java.util.Scanner;

/**
 * IOHandlerStandard: uses standard IO for input (via get method) and output (via put method).
 * Note: exceptions are potentially thrown by methods of Scanner; refer to documentation in Java standard library. 
 */
public class IOHandlerStandard implements IOHandlerInterface
{
    // Attributes
    private Scanner input;

    /**
     * constructor: 
     * @param none
     */
    public IOHandlerStandard()
    {
        input = new Scanner (System.in);
    }

    /**
     * get: 
     * @param a String, prompt to display to standard output destination.
     * @return a String, user input from standard input source.
     */
    @Override
    public String get(String prompt)
    {
        System.out.print (prompt);
        return input.next();
    } // end get

    /**
     * put: 
     * @param a String to write to the selected destination.
     */
    @Override
    public void put(String output)
    {
        System.out.println (output);
    } // end put

} // end IOHandlerStandard