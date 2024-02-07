package parkinglot.repositories;

import parkinglot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private final Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public Optional<ParkingLot> findByGateId(Long gateId) {
        return Optional.ofNullable(parkingLotMap.getOrDefault(parkingLotMap.get(gateId), null));
    }
}
