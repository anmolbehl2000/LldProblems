package ParkingLotSystem;

import java.util.List;
import ParkingLotSystem.Vehicle.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingLevel {
    private int floor;
    private List<ParkingSpot> spots;

    public ParkingLevel(int floor)
    {
        this.floor = floor;
        this.spots = new CopyOnWriteArrayList<>();
    }

    public boolean checkAvailablity()
    {
        for(ParkingSpot spot:this.spots)
        {
            if(spot.isAvailable())
            return true;
        }
        return false;
    }

    public boolean parkVehicle(Vehicle vehicle)
    {
        for(ParkingSpot spot:this.spots)
        {
            if(spot.isAvailable()&&spot.canFit(vehicle))
            {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle)
    {
        for(ParkingSpot spot:this.spots)
        {
            if(spot.getParkedVehicle(vehicle).equals(vehicle))
            {
                spot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public int fetchAvailablity()
    {
        int vacantSpots = 0;
        for(ParkingSpot spot: spots)
        {
            if(spot.isAvailable())
            vacantSpots++;
        }
        return vacantSpots;
    }
}
