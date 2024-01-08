package design.patterns.factory.interest.calculator.account;

import design.patterns.factory.interest.calculator.method.InterestCalculator;

public interface Account {
    void setInterestCalculator(InterestCalculator interestCalculator);
    double accrueInterest();
}
