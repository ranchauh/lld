package tictactoe.factory;

import tictactoe.model.BotDifficultyLevel;
import tictactoe.strategy.botplayingstrategy.BotPlayingStrategy;
import tictactoe.strategy.botplayingstrategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy createBotPlayingStrategy(BotDifficultyLevel difficultyLevel) {
        switch (difficultyLevel) {
            case EASY -> {
                return new EasyBotPlayingStrategy();
            }
            default -> {
                return new EasyBotPlayingStrategy();
            }
        }
    }
}
