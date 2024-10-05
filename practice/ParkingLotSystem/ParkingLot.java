package ParkingLotSystem;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ParkingLotSystem.Vehicle.Vehicle;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingLevel> levels;

    private ParkingLot(int numLevels)
    {
        levels = new CopyOnWriteArrayList<>();
        for(int i=1;i<=numLevels;i++)
        levels.add(new ParkingLevel(numLevels));
    }

    public static ParkingLot getInstance(int numLevels)
    {
        if(instance==null)
        {
            synchronized(ParkingLot.class)
            {
                if(instance==null)
                {
                    instance = new ParkingLot(numLevels);
                }
            }
        }
        return instance;
    }

    public boolean parkVehicle(Vehicle vehicle)
    {
        for (ParkingLevel level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingLevel level : levels) {
            if (level.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public String displayAvailablity()
    {
        // display status
        return "";
    }

}
