package ParkingLotSystem.Vehicle;

public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;
    
    Vehicle(String vehicleNumber,VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber()
    {
        return this.vehicleNumber;
    }

    public VehicleType getVehicleType()
    {
        return this.vehicleType;
    }
}
