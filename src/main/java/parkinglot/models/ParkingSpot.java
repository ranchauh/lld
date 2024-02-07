package parkinglot.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ParkingSpot extends BaseModel {
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private List<VehicleType> vehicleTypes;
}
