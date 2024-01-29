package tictactoe.strategy.gamewinningstrategy;

import tictactoe.model.Board;
import tictactoe.model.Move;

public interface GameWinningStrategy {
    boolean evaluate(Board board, Move move);
}
