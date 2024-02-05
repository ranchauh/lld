package parkinglot.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import parkinglot.models.*;

import java.sql.Date;

@Builder
public class IssueTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;
}
