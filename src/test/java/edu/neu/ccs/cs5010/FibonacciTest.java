package edu.neu.ccs.cs5010;
import edu.neu.ccs.cs5010.*;

import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
/**
 * FibonacciTest is a glassbox test of the Fibonacci class.
 *
 * Recall that the Fibonacci sequence is a recursive
 * sequence where the first two terms of the sequence are 1 and all subsequent
 * terms are the sum of the previous two terms.
 *
 * Thus, the Fibonacci sequence starts out as 1, 1, 2, 3, 5, 8, 13...
 * The first 1 in the sequence is considered the "0th" term,
 * so the indices that <code>Assignment1.Fibonacci</code> uses are 0-based.
 *
 * @see Assignment1.Fibonacci
 *
 * @author PDP staff
 */
public class FibonacciTest {
    private static Fibonacci fib = null;

    @BeforeClass
    public static void setupBeforeTests() throws Exception{
        fib = new Fibonacci();
    }
    /**
     * Tests that Fibonacci throws an IllegalArgumentException
     * for a negative number.
     */
    @Test(expected = IllegalArgumentException.class)
    public void expectedIllegalArgumentException(){
        fib.getFibTerm(-1);

    }
    /**
     * Tests that Fibonacci throws no IllegalArgumentException
     * for zero or for a positive number.
     */
    @Test
    public void testThrowsIllegalArgumentException(){

        try{
            fib.getFibTerm(0);

        }catch (IllegalArgumentException ex){
            fail(" Threw IllegalArgumentException for 0 but 0 is nonnegative:"+ex);
        }

        try{
            fib.getFibTerm(1);

        }catch (IllegalArgumentException ex){
            fail(" Threw IllegalArgumentException for 1 but 1 is nonnegative:"+ex);
        }
    }
    /** Tests to see that Fibonacci returns the correct value for the base cases, n=0 and n=1 */
    @Test
    public void testBaseCase(){
        assertEquals("getFibTerm(0)",1,fib.getFibTerm(0));
        assertEquals("getFibTern(1)",1,fib.getFibTerm(1));

    }
    /** Tests inductive cases of the Fibonacci sequence */
    @Test
    public void testInductiveCase(){
        int[][] cases = new int[][]{
                {2, 2},
                {3, 3},
                {4, 5},
                {5, 8},
                {6, 13},
                {7, 21}
        };
        for(int i=0; i<cases.length; i++)
        {
            assertEquals("getFibterm("+cases[i][0]+")",cases[i][1], fib.getFibTerm(cases[i][0]));


        }
    }
}
