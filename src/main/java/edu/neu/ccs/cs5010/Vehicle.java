/**
 * This is part of Assignment 1: Environment Setup and Review of Java for PDP, Fall 2017.
 */
package edu.neu.ccs.cs5010;

/**
 * Vehicle is a simple object that has a velocity and a direction.
 */
// You may not make Ball implement the Comparable interface.
public class Vehicle {

   private double velocity;
   private int direction;
   
    /**
     * Constructor that creates a new vehicle object with the specified velocity and direction.
     * @param velocity Velocity of the new object.
     * @param direction Direction of the new object, where 1 represents eastbound direction, and 2 westbound direction.
     */
    public Vehicle(double velocity, int direction) {
        this.velocity = velocity; //using this. to differentiate the class' variable and input variable
        this.direction = direction; // using this. to differentiate the class's variable and inpuut variable
    }

    /**
     * Returns the velocity of the Vehicle.
     * @return the velocity of the Vehicle.
     */
    public double getVelocity() {
        return velocity; //change to return velocity
    }

   /**
     * Returns the direction of the Vehicle.
     * @return the direction of the Vehicle.
     */
    public int getDirection() {
        return direction; // change to return direction,and also change the return type double to int
    }

    public void setVelocity(double velocity){
        this.velocity = velocity; //for the use in ScenicRoad.java
    }
}

