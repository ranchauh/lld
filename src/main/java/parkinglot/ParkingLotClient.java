package parkinglot;

import parkinglot.controllers.TicketController;
import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.dtos.ResponseStatus;
import parkinglot.models.SpotAssignmentStrategyType;
import parkinglot.models.VehicleType;
import parkinglot.repositories.*;
import parkinglot.services.TicketService;
import parkinglot.services.TicketServiceImpl;

public class ParkingLotClient {
    public static void main(String[] args) {
        // TODO: insert master data for all the repositories
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        TicketService ticketService = new TicketServiceImpl(gateRepository,
                vehicleRepository, parkingLotRepository, parkingSpotRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);
        IssueTicketResponseDto responseDto = ticketController.issueTicket(IssueTicketRequestDto.builder()
                .spotAssignmentStrategyType(SpotAssignmentStrategyType.RANDOM)
                .gateId(1L)
                .vehicleType(VehicleType.HATCHBACK)
                .ownerName("Randheer")
                .vehicleNumber("KA01HU7890")
                .build());
        if(responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            System.out.println("Ticket Booked. Ticket Number: " + responseDto.getTicket().getTicketNumber());
        } else {
            System.out.println("Ticket booking failed");
        }
    }
}
