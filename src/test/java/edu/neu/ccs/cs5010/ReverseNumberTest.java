package edu.neu.ccs.cs5010;
import edu.neu.ccs.cs5010.*;
import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

/**
 * ReverseNumberTest is a glass box test of ReverseNumber class.
 * ReverseNumber class return the reversed number of a given integer
 * @author Zhenyan Lin
 */
public class ReverseNumberTest {
    private static ReverseNumber rev = null;

    @BeforeClass
    public static void setupBeforeTests() throws Exception{
        rev = new ReverseNumber();
    }

    /**
     * Test that ReverseNumber.Reverse() throws an IllegalArgumentException
     * for a given integer whose reversed number exceeds the maximum of int
     */
    @Test(expected = IllegalArgumentException.class)
    public void expectIllegalArgumentException(){
        rev.Reverse(1234567899);
    }

    /**
     * Test to see that whether ReverseNumber.Reverse() returns the correct number for a given set of integer
     */
    @Test
    public void testInductiveCase(){
        int[][] cases = new int[][]{
                {123, 321},
                {-343, -343},
                {0, 0},
                {1000, 1},
                {5,5}

        };
        for(int i=0; i<cases.length; i++)
        {
            assertEquals("reverse("+cases[i][0]+")",cases[i][1], rev.Reverse(cases[i][0]));


        }
    }
}
