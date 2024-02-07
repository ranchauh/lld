package parkinglot.services;

import parkinglot.exception.GateNotFoundException;
import parkinglot.exception.ParkingLotNotFoundException;
import parkinglot.models.SpotAssignmentStrategyType;
import parkinglot.models.Ticket;
import parkinglot.models.VehicleType;

public interface TicketService {
    Ticket issueTicket(Long gateId, String ownerName, VehicleType vehicleType, String vehicleNumber, SpotAssignmentStrategyType spotAssignmentStrategyType) throws GateNotFoundException, ParkingLotNotFoundException;
}
