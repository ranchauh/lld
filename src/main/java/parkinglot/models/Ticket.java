package parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Builder
public class Ticket extends BaseModel {
    private String ticketNumber;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate gateGeneratedAt;
    private TicketStatus ticketStatus;
}
