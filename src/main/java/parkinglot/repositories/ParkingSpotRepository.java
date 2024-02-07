package parkinglot.repositories;

import parkinglot.models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private final Map<Long, ParkingSpot> parkingSpotMap = new HashMap<>();

    private long parkingSpotId;

    public ParkingSpot save(ParkingSpot parkingSpot) {
        if(parkingSpotMap.containsKey(parkingSpot.getId())) {
            parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        } else {
            this.parkingSpotId++;
            parkingSpot.setId(parkingSpotId);
            parkingSpotMap.put(parkingSpotId, parkingSpot);
        }
        return parkingSpot;
    }
}
