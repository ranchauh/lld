package parkinglot.models;

import java.sql.Date;
import java.util.List;

public class Bill extends BaseModel {
    private Date exitTime;
    private Double amount;
    private Ticket ticket;
    private Gate gate;
    private Operator operator;
    private BillStatus billStatus;
    private List<Payment> payments;
}
