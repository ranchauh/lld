package tictactoe.model;

import lombok.Getter;
import lombok.Setter;
import tictactoe.factory.BotPlayingStrategyFactory;
import tictactoe.strategy.botplayingstrategy.BotPlayingStrategy;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;

    protected BotPlayingStrategy botPlayingStrategy;

    public Bot(int id, String name, Symbol symbol) {
        super(id, name, symbol, PlayerType.BOT);
        this.difficultyLevel = BotDifficultyLevel.EASY;
        botPlayingStrategy = BotPlayingStrategyFactory.createBotPlayingStrategy(this.difficultyLevel);
    }

    public Bot(int id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.createBotPlayingStrategy(this.difficultyLevel);
    }

    @Override
    public Move makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
