package parkinglot.models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> vehicleTypes;
}
