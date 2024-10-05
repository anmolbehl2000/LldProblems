package ParkingLotSystem;

import java.util.Vector;

import ParkingLotSystem.Vehicle.*;

public class ParkingSpot {
    boolean occupied;
    VehicleType spotType;
    Vehicle Vehicle;

    public ParkingSpot(VehicleType spotType)
    {
        this.occupied = false;
        this.spotType = spotType;
    }

    public boolean isAvailable()
    {
        return !this.occupied;
    }

    public boolean canFit(Vehicle vehicle)
    {
        return this.spotType==vehicle.getVehicleType();
    }

    public void parkVehicle(Vehicle vehicle)
    {
        this.Vehicle = vehicle;
        this.occupied = true;
    }

    public void unparkVehicle()
    {
        this.Vehicle = null;
        this.occupied = false;
    }

    public Vehicle getParkedVehicle(Vehicle vehicle)
    {
        if(this.occupied)
        {
            return this.Vehicle;
        }
        return null; // no vehicle parked
    }
}
