package parkinglot.models;

public class Gate extends BaseModel{
    private GateType type;
    private int gateNumber;
    private Operator currentOperator;
    private GateStatus gateStatus;
}
