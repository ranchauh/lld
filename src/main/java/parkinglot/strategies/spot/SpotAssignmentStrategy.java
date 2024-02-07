package parkinglot.strategies.spot;

import parkinglot.exception.ParkingLotNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;
import parkinglot.models.ParkingSpot;
import parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingLotNotFoundException;
}
