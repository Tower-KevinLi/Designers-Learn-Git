package edu.neu.ccs.cs5010;
import edu.neu.ccs.cs5010.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * VehicleTest is a glass box test of Vehicle class.
 * Vehicle class is an object which has two methods, getVelocity() and getDirection()
 * @author Zhenyan Lin
 */
import static junit.framework.TestCase.assertEquals;

public class VehicleTest {
    private static Vehicle v;
    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        v = new Vehicle(5.6, 1);
    }
    /**
     * Test to see that whether getVelocity() returns the correct number
     */
    @Test
    public void testVelocity() {
        assertEquals("velocity",5.6,v.getVelocity());
    }
    /**
     * Test to see that whether getDirection() returns the correct number
     */
    @Test
    public void testDirection(){
        assertEquals("Direction",1,v.getDirection());
    }

}
