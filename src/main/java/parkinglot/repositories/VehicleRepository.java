package parkinglot.repositories;

import parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private final Map<Long, Vehicle> vehicleMap = new HashMap<>();
    private final Map<String, Vehicle> vehicleNumberMap = new HashMap<>();

    private long incrementalVehicleId;

    public Optional<Vehicle> findVehicleByid(Long vehicleId) {
        if(vehicleMap.containsKey(vehicleId)) {
            return Optional.of(vehicleMap.get(vehicleId));
        }
        return Optional.empty();
    }

    public Optional<Vehicle> findVehicleByNumber(String vehicleNumber) {
        if(vehicleNumberMap.containsKey(vehicleNumber)) {
            return Optional.of(vehicleNumberMap.get(vehicleNumber));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle) {
        this.incrementalVehicleId++;
        vehicle.setId(this.incrementalVehicleId);
        this.vehicleMap.put(incrementalVehicleId, vehicle);
        this.vehicleNumberMap.put(vehicle.getVehicleNumber(), vehicle);
        return vehicle;
    }
}
