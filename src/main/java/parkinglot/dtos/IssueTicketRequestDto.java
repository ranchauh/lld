package parkinglot.dtos;

import lombok.Getter;
import lombok.Setter;
import parkinglot.models.SpotAssignmentStrategyType;
import parkinglot.models.VehicleType;

@Getter
@Setter
public class IssueTicketRequestDto {
    private Long gateId;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
}
