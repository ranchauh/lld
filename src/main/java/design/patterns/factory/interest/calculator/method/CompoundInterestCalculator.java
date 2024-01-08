package design.patterns.factory.interest.calculator.method;

public class CompoundInterestCalculator implements InterestCalculator {

    double principal;

    double days;

    double interestRate;

    @Override
    public double calculateInterest() {
        double A = principal *
                (Math.pow((1 + interestRate / 100), days));

        return A - principal;
    }
}
