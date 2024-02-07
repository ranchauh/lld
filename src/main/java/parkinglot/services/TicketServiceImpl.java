package parkinglot.services;

import lombok.NonNull;
import parkinglot.exception.GateNotFoundException;
import parkinglot.exception.ParkingLotNotFoundException;
import parkinglot.factories.SpotAssignmentStrategyFactory;
import parkinglot.models.*;
import parkinglot.repositories.*;
import parkinglot.strategies.spot.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketServiceImpl implements TicketService {

    private final GateRepository gateRepository;

    private final VehicleRepository vehicleRepository;

    private final ParkingLotRepository parkingLotRepository;

    private final ParkingSpotRepository parkingSpotRepository;

    private final TicketRepository ticketRepository;

    private long ticketNumber;

    public TicketServiceImpl(@NonNull GateRepository gateRepository,
                             @NonNull VehicleRepository vehicleRepository,
                             @NonNull ParkingLotRepository parkingLotRepository,
                             @NonNull ParkingSpotRepository parkingSpotRepository,
                             @NonNull TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId, String ownerName, VehicleType vehicleType,
                              String vehicleNumber, SpotAssignmentStrategyType spotAssignmentStrategyType)
            throws GateNotFoundException, ParkingLotNotFoundException {
        // generate ticket logic
        // 1. Fetch the gate object from DB.
        // 2. Fetch the Vehicle details from DB with Vehicle number
        // 3. Validate the user details
        // 4. Book the ticket

        Optional<Gate> gateOptional = this.gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()) {
            throw new GateNotFoundException("Invalid gate id");
        }

        Optional<Vehicle> vehicleOptional = this.vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isPresent()) {
            vehicle = vehicleOptional.get();
        } else {
            vehicle =  Vehicle.builder()
                    .vehicleNumber(vehicleNumber)
                    .ownerName(ownerName)
                    .vehicleType(vehicleType)
                    .build();
            this.vehicleRepository.save(vehicle);
        }

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findByGateId(gateOptional.get().getId());
        if(optionalParkingLot.isEmpty()) {
            throw new ParkingLotNotFoundException("parking lot not found");
        }
        ParkingLot parkingLot = optionalParkingLot.get();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);

        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, vehicleType);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.ASSIGNED);
        this.parkingSpotRepository.save(parkingSpot);

        Ticket ticket = Ticket.builder()
                .ticketNumber(String.valueOf(this.ticketNumber++))
                .ticketStatus(TicketStatus.BOOKED)
                .entryTime(new Date())
                .parkingSpot(parkingSpot)
                .gateGeneratedAt(gateOptional.get())
                .vehicle(vehicle)
                .build();

        return ticketRepository.save(ticket);
    }

}
