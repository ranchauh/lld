package parkinglot.models;

import java.sql.Date;

public class Ticket extends BaseModel {
    private String ticketNumber;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate gateGeneratedAt;
    private TicketStatus ticketStatus;
}
