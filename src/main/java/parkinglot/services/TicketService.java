package parkinglot.services;

import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.models.Ticket;
import parkinglot.models.VehicleType;

public interface TicketService {
    Ticket issueTicket(Long gateId, String ownerName, VehicleType vehicleType, String vehicleNumber);
}
