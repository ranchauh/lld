package parkinglot.controllers;

import lombok.NonNull;
import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.dtos.IssueTicketResponseDto;
import parkinglot.dtos.ResponseStatus;
import parkinglot.models.Ticket;
import parkinglot.services.TicketService;

public class TicketController {
    private final TicketService ticketService;

    public TicketController(@NonNull TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto issueTicketRequestDto) {
        try {
            Ticket ticket = ticketService.issueTicket(issueTicketRequestDto.getGateId(),
                    issueTicketRequestDto.getOwnerName(),
                    issueTicketRequestDto.getVehicleType(),
                    issueTicketRequestDto.getVehicleNumber());
            return IssueTicketResponseDto.builder()
                    .responseStatus(ResponseStatus.SUCCESS)
                    .ticket(ticket)
                    .build();
        } catch (Exception e) {
            return IssueTicketResponseDto.builder()
                    .responseStatus(ResponseStatus.FAILED)
                    .build();
        }
    }

}
