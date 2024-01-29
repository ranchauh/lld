package tictactoe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;


    Bot(int id, String name, Symbol symbol, PlayerType playerType) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = BotDifficultyLevel.EASY;
    }

    Bot(int id, String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel difficultyLevel) {
        super(id, name, symbol, playerType);
        this.difficultyLevel = difficultyLevel;
    }
}
