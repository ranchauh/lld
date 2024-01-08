package design.patterns.factory.interest.calculator.method;

public class InterestCalculator30By360 implements InterestCalculator {

    double principal;

    double days;

    double interestRate;

    @Override
    public double calculateInterest() {
        double dailyRate = interestRate/360;
        double monthlyRate = dailyRate * 30;
        return (principal * monthlyRate * days/30 )/ 100;
    }
}
