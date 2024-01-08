package design.patterns.factory.interest.calculator;

import design.patterns.factory.interest.calculator.method.*;

import java.util.Map;

public class InterestCalculatorFactory {
    private static final Map<InterestCalculatorMethod, InterestCalculator> IC_MAP = Map.of(
            InterestCalculatorMethod.SIMPLE, new SimpleInterestCalculator(),
            InterestCalculatorMethod.COMPOUND, new CompoundInterestCalculator(),
            InterestCalculatorMethod.THIRTY_BY_360, new InterestCalculator30By360(),
            InterestCalculatorMethod.ACTUAL_BY_360, new InterestCalculatorActualBy360(),
            InterestCalculatorMethod.ACTUAL_BY_365, new InterestCalculatorActualBy365()
            );

    public static InterestCalculator getInterestCalculator(InterestCalculatorMethod method) {
        return IC_MAP.get(method);
    }
}
