package tictactoe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;

    Bot(int id, String name, Symbol symbol) {
        super(id, name, symbol, PlayerType.BOT);
        this.difficultyLevel = BotDifficultyLevel.EASY;
    }

    Bot(int id, String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol, PlayerType.BOT);
        this.difficultyLevel = difficultyLevel;
    }
}
