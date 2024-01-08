package design.patterns.factory.interest.calculator.account;

import design.patterns.factory.interest.calculator.method.InterestCalculator;

public class SavingsAccount implements Account {

    InterestCalculator interestCalculator;

    @Override
    public void setInterestCalculator(InterestCalculator interestCalculator) {
        this.interestCalculator = interestCalculator;
    }

    @Override
    public double accrueInterest() {
        return this.interestCalculator.calculateInterest();
    }
}
