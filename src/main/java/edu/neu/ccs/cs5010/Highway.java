/**
 * This is part of Assignment 1: Environment Setup and Review of Java for PDP, Fall 2017
 */
package edu.neu.ccs.cs5010;

import java.lang.Iterable;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Collections;

/**
 * This is a container that can be used to contain Vehicles.
 * A given Vehicle may only appear on a Highway once.
 */
public class Highway implements Iterable<Vehicle> {

    // Contents of the Highway.
    private Set<Vehicle> contents;
    private int numE;
    private int numW;
    /**
     * Constructor that creates a new Highway.
     */
    public Highway() {
            contents = new LinkedHashSet<Vehicle>();
            numE = 0;
            numW = 0;
    }

   /**
     * Implements the Iterable interface for this container.
          * @return an Iterator over the Vehicle objects contained
     * in this container.
     */
    public Iterator<Vehicle> iterator() {
           // If we just returned the iterator of "contents", a client
        // could call the remove() method on the iterator and modify
        // it behind our backs.  Instead, we wrap contents in an
        // "unmodifiable set"; calling remove() on this iterator
        // throws an exception.  This is an example of avoiding
        // "representation exposure."  
        return Collections.unmodifiableSet(contents).iterator();
    }

    /**
     * Adds a vehicle on the Highway. This method returns <tt>true</tt>
     * if a Vehicle was successfully added on the Highway, i.e. vehicle is
     * not already on the Highway. (You are allowed to put
     * a Vehicle on a Highway only once. Hence, this method returns
     * <tt>false</tt>, if a Vehicle is already on the Highway).
     * @param v Vehicle to be added.
     * @requires v != null.
     * @return true if vehicle was successfully added on the highway,
     * i.e. vehicle is not already on the highway. Returns false, if vehicle is
     * already on the highway.
     */
    public boolean add(Vehicle v) {
        // Your code goes here.  Remove the exception after you're done.
       boolean res = contents.add(v);
        if(res) {
            if (v.getDirection() == 1)
                numE++;
            else
                numW++;

        }
        return res;

    }

    /**
     * Removes a vehicle from the highway. This method returns
     * <tt>true</tt> if vehicle was successfully removed from the
     * highway, i.e. vehicle is actually on the highway. You cannot
     * remove a Vehicle if it is not already on the Highway, and so ths
     * method will return <tt>false</tt>, otherwise.
     * @param v Vehicle to be removed.
     * @requires v != null.
     * @return true if vehicle was successfully removed from the Highway,
     * i.e. vehicle is actually on the highway. Returns false, if vehicle is not
     * on the highway.
     */
    public boolean remove(Vehicle v) {
        // Your code goes here.  Remove the exception after you're done.
      boolean res = contents.remove(v);
      if(res) {
          if (v.getDirection() == 1)
              numE--;
          else
              numW--;
      }
        return res;
    }

    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Eastbound direction of the highway.
     * @return the velocity of the slowest eastbound vehicle
     */
    public double getVelocityEastbound() {
        // Your code goes here.  Remove the exception after you're done.

        double min = Integer.MAX_VALUE;
        for(Vehicle v : contents){
            if(v.getDirection()==1)
                min = min > v.getVelocity() ? v.getVelocity() : min;
        };
        return min;
    }
    
    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Westbound direction of the highway.
     * @return the velocity of the slowest westbound vehicle
     */
    public double getVelocityWestbound() {
        // Your code goes here.  Remove the exception after you're done.
        double min = Integer.MAX_VALUE;
        for(Vehicle v : contents){
            if(v.getDirection()==2)
                min = min > v.getVelocity() ? v.getVelocity() : min;
        };
        return min;
    }

    /**
     * Returns the number of Vehicles headed Eastbound.
     * @return the number of Vehicles headed Eastbound on the highway
     */
    public int numberVehiclesEastbound() {
        // Your code goes here.  Remove the exception after you're done.
        return numE;
    }
    
     /**
     * Returns the number of Vehicles headed Westbound.
     * @return the number of Vehicles headed Westbound on the highway
     */
    public int numberVehiclesWestbound() {
        // Your code goes here.  Remove the exception after you're done.
        return numW;
    }

    /**
     * This method returns <tt>true</tt> if a specific Vehicle is on the Highway. 
	 * It will return <tt>false</tt> otherwise.
	 * @param v Vehicle to be checked if its on the Highway
     * @requires v != null.
     * @return true if this vehicle is on the Highway. Returns
     * false, otherwise.
     */
    public boolean contains(Vehicle v) {
       // Your code goes here.  Remove the exception after you're done.
        return contents.contains(v);
    }




}