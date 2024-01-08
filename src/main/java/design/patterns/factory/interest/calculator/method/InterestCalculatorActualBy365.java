package design.patterns.factory.interest.calculator.method;

public class InterestCalculatorActualBy365 implements InterestCalculator {

    double principal;

    double days;

    double interestRate;

    @Override
    public double calculateInterest() {
        double dailyRate = interestRate/365;
        double monthlyRate = dailyRate * days;
        return (principal * monthlyRate * days/30 )/ 100;
    }
}
