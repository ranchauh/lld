package parkinglot.strategies.spot;

import parkinglot.exception.ParkingLotNotFoundException;
import parkinglot.models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) throws ParkingLotNotFoundException {
        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                 && parkingSpot.getVehicleTypes().contains(vehicleType)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
