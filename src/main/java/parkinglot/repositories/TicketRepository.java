package parkinglot.repositories;

import parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private final Map<Long, Ticket> ticketMap = new HashMap<>();
    private long ticketId;

    public Ticket save(Ticket ticket) {
        if(ticketMap.containsKey(ticket.getId())) {
            ticketMap.put(ticket.getId(), ticket);
        } else {
            ticket.setId(ticketId++);
            ticketMap.put(ticket.getId(), ticket);
        }
        return ticket;
    }
}
