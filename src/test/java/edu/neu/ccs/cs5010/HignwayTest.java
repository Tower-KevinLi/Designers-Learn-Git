package edu.neu.ccs.cs5010;
import edu.neu.ccs.cs5010.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
/**
 * HighwayTest is a glass box test of Vehicle class.
 * Highway class is a container that can be used to contain Vehicles
 * @author Zhenyan Lin
 */


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HignwayTest {
    private static Highway highway;

    @BeforeClass
    public static void setupBeforeTests() throws Exception {
        highway = new Highway();
        Vehicle v1 = new Vehicle(7.1,1);
        Vehicle v2 = new Vehicle( 8.1,1);
        Vehicle v3 =new Vehicle(2.3,2) ;
        highway.add(v1);
        highway.add(v2);
        highway.add(v3);
    }
    /**
     * Test to see that whether add() returns the correct boolean value
     */
    @Test
    public void testAdd(){
        Vehicle v = new Vehicle(6.7,1);
        assertTrue("add new Vehicle to Highway",highway.add(v));
        assertFalse("add new Vehicle to Highway",highway.add(v));
    }

    /**
     * Test to see that whether remove() returns the correct boolean value
     */
    @Test
    public void testRemove(){
        Vehicle v = new Vehicle(9.3,2);
        boolean add= highway.add(v);
        assertTrue("remove Vehicle",highway.remove(v));
        assertFalse("remove Vehicle",highway.remove(v));
    }
    /**
     * Test to see that whether getVelocityEastbound() returns the correct number
     */
    @Test
    public void testGetVelocityEastbound(){

        assertEquals("eastbound minimum velocity",6.7,highway.getVelocityEastbound(),0);

    }
    /**
     * Test to see that whether getVeolocityWestbound() returns the correct number
     */
    @Test
    public void testGetVelocityWest(){
        assertEquals("westbound minimum velocity",2.3,highway.getVelocityWestbound(),0.0);
    }
    /**
     * Test to see that whether numberVehiclesEastbound() returns the correct boolean value
     */
    @Test
    public void testNumberVehicleEastbound(){
        assertEquals("number of vehicle towards East",4,highway.numberVehiclesEastbound());
    }
    /**
     * Test to see that whether numberVehiclesWastbound() returns the correct boolean value
     */
    @Test
    public void testNumberVehicleWestbound(){
        assertEquals("number of vehicle towards West",1,highway.numberVehiclesWestbound());
    }
    /**
     * Test to see that whether contains() returns the correct boolean value
     */
    @Test
    public void testContains(){
        Vehicle v = new Vehicle(9.5,1);
        boolean add= highway.add(v);
        assertTrue("check element",highway.contains(v));
    }
}
