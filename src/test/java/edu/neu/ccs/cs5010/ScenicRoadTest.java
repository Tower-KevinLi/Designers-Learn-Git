package edu.neu.ccs.cs5010;
import edu.neu.ccs.cs5010.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * ScenicrRoadTest is a glass box test of Vehicle class.
 * ScenicRoad class is a container that can be used to contain Vehicles with a bandwidth. When the number
 * of vehicle in one direction exceeds the maximum number,for those vehicle whose present velocity is
 * lareger than 5, they will slow down to 5mph. For those whose velocity is smaller than 5mph,
 * they will keep their present velocity.
 *
 * @author Zhenyan Lin
 */
public class ScenicRoadTest {

    private static ScenicRoad sr;

    @BeforeClass
    public static void setUp() throws Exception{
        sr = new ScenicRoad(4);
        Vehicle v1 = new Vehicle(7.5,1);
        Vehicle v2 = new Vehicle(2.0,1);
        Vehicle v3 = new Vehicle(6.3,1);
        Vehicle v4 = new Vehicle(7.6,2);
        Vehicle v5 = new Vehicle(3.5,1);
        Vehicle v6 = new Vehicle(1.0,2);
        sr.add(v1);
        sr.add(v2);
        sr.add(v3);
        sr.add(v4);
        sr.add(v5);
        sr.add(v6);
    }
    /**
     * Test to see that whether add() returns the correct boolean value
     */
    @Test
    public void testAdd(){
        Vehicle v = new Vehicle(6.7,1);
        assertTrue("add new Vehicle to Highway",sr.add(v));
        assertFalse("add new Vehicle to Highway",sr.add(v));
    }

    /**
     * Test to see when the number exceeds the bandwidth, will the velocity slow down to 5 for those whose
     * present velocity is larger than 5, and will the velocity keep their present value for those whose
     * present velocity is smaller than 5
     */
    @Test
    public void testVelovityAfterMaximum(){
        double[] result = { 5.0, 2.0,5.0,5.0,3.5,1.0,5.0};
        Iterator<Vehicle> iter = sr.iterator();
        int i = 0;
        while(iter.hasNext()) {
            assertEquals("all vehicles' velocity", result[i], iter.next().getVelocity(), 0.0);
            i++;
        }
    }


}
