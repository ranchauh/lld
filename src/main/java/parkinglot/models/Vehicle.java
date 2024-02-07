package parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Vehicle extends BaseModel {
    private String vehicleNumber;
    private String ownerName;
    private VehicleType vehicleType;
}
