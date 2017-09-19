package edu.neu.ccs.cs5010;
import edu.neu.ccs.cs5010.*;

import java.util.Iterator;
import java.lang.Iterable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ScenicRoad is much like a Highway besides it has limitation on bandwidth(the maximum number of vehicle in one
 * direction
 *
 * @author Zhenyan Lin
 */
public class ScenicRoad{
    private int bandwidth;
    private Highway highway;

    /**
     * constructor that creastes a new ScenicRoad
     * @param bandwidth the maximum number of vehicle in each direction
     */
    public ScenicRoad(int bandwidth) {
        this.bandwidth = bandwidth;
        highway = new Highway();
    }

    /**
     * Adds a vehicle on the ScenicRoad. This method returns true
     * if a Vehicle was successfully added on the ScenicRoad, i.e. vehicle is
     * not already on the Highway. Hence, this method returns
     * false, if a Vehicle is already on the Highway) If the present number of
     * vehicle in the one direction of ScenicRoad exceeds the bandwidth,for those vehicle whose present velocity is
     * lareger than 5, their velocity will slow down to 5mph. For those whose velocity is smaller than 5mph,
     * their velocity will keep their present velocity.
     * @param e Vehicle to be added.
     * @requires e != null.
     * @return true if vehicle was successfully added on the highway,
     * i.e. vehicle is not already on the highway. Returns false, if vehicle is
     * already on the highway.
     */
    public boolean  add(Vehicle e){

        boolean re = highway.add(e);

        if(highway.numberVehiclesEastbound() >= bandwidth || highway.numberVehiclesWestbound() >= bandwidth){

            Iterator<Vehicle> iter = highway.iterator();

            while(iter.hasNext()){
                Vehicle v = iter.next();
                    if(v.getVelocity() >= 5.0)
                     v.setVelocity(5.0);

            }

        }
        return re;
    }
    /**
     * Removes a vehicle from the scenicroad. This method returns
     * <tt>true</tt> if vehicle was successfully removed from the
     * scenicroad, i.e. vehicle is actually on the scenicroad. You cannot
     * remove a Vehicle if it is not already on the scenicroad, and so ths
     * method will return <tt>false</tt>, otherwise.
     * @param v Vehicle to be removed.
     * @requires v != null.
     * @return true if vehicle was successfully removed from the scenicroad,
     * i.e. vehicle is actually on the scenicroad. Returns false, if vehicle is not
     * on the scenicroad.
     */
    public boolean remove(Vehicle v){
        return highway.remove(v);
    }
    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Eastbound direction of the scenicroad.
     * @return the velocity of the slowest eastbound vehicle
     */
    public double getVelocityEastbound(){
        return highway.getVelocityEastbound();
    }
    /**
     * Each Vehicle has a velocity. This method returns the velocity of the slowest vehicle in the Westbound direction of the scenicroad.
     * @return the velocity of the slowest westbound vehicle
     */
    public double getVelocityWestbound(){
        return highway.getVelocityWestbound();
    }
    /**
     * Returns the number of Vehicles headed Eastbound.
     * @return the number of Vehicles headed Eastbound
     */
    public int numberVehicleEastbound(){
        return highway.numberVehiclesEastbound();
    }
    /**
     * Returns the number of Vehicles headed Westbound.
     * @return the number of Vehicles headed Westbound
     */
    public  int numberVehicleWestbound(){
        return highway.numberVehiclesWestbound();
    }
    /**
     * Implements the Iterable interface for this container.
     * @return an Iterator over the Vehicle objects contained
     * in this container.
     */
    public Iterator<Vehicle> iterator(){
        return highway.iterator();
    }
    /**
     * This method returns <tt>true</tt> if a specific Vehicle is on the scenicroad.
     * It will return <tt>false</tt> otherwise.
     * @param v Vehicle to be checked if is's on the scenicroad
     * @requires v != null.
     * @return true if this vehicle is on the scenicroad. Returns
     * false, otherwise.
     */
    public boolean contains(Vehicle v){
        return highway.contains(v);
    }

}
