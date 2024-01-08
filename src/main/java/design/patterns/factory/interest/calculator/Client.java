package design.patterns.factory.interest.calculator;

import design.patterns.factory.interest.calculator.account.Account;
import design.patterns.factory.interest.calculator.account.SavingsAccount;
import design.patterns.factory.interest.calculator.method.InterestCalculator;

public class Client {
    public static void main(String[] args) {
        InterestCalculator ic = InterestCalculatorFactory.getInterestCalculator(InterestCalculatorMethod.SIMPLE);
        Account account = new SavingsAccount();
        account.setInterestCalculator(ic);
        account.accrueInterest();
    }
}
