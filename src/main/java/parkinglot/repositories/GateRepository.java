package parkinglot.repositories;

import parkinglot.models.Gate;
import parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    Map<Long, Gate> gateMap = new HashMap<>();

    private long incrementalGateId;

    public Optional<Gate> findGateById(Long gateId) {
        if(gateMap.containsKey(gateId)) {
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

    public Gate save(Gate gate) {
        this.incrementalGateId++;
        gate.setId(this.incrementalGateId);
        this.gateMap.put(incrementalGateId, gate);
        return gate;
    }

}
