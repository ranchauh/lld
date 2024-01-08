package design.patterns.factory.interest.calculator.method;

public class InterestCalculatorActualBy360 implements InterestCalculator {

    double principal;

    double days;

    double interestRate;

    @Override
    public double calculateInterest() {
        double dailyRate = interestRate/360;
        double monthlyRate = dailyRate * days;
        return (principal * monthlyRate * days/30 )/ 100;
    }
}
