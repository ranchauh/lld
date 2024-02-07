package parkinglot.factories;

import parkinglot.models.SpotAssignmentStrategyType;
import parkinglot.strategies.spot.CheapestSpotAssignmentStrategy;
import parkinglot.strategies.spot.RandomSpotAssignmentStrategy;
import parkinglot.strategies.spot.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssignmentStrategyType spotAssignmentStrategyType
    ) {
        switch (spotAssignmentStrategyType) {
            case RANDOM -> {
                return new RandomSpotAssignmentStrategy();
            }
            case CHEAPEST -> {
                return new CheapestSpotAssignmentStrategy();
            }
        }
        return new RandomSpotAssignmentStrategy();
    }
}
