package design.patterns.factory.interest.calculator.method;

public class SimpleInterestCalculator implements InterestCalculator {

    double principal;

    double days;

    double interestRate;

    @Override
    public double calculateInterest() {
        return (principal * interestRate * days)/100;
    }
}
