package tictactoe.strategy.botplayingstrategy;

import tictactoe.model.Board;
import tictactoe.model.Move;

import java.util.Optional;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
