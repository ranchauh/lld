package tictactoe.strategy.gamewinningstrategy;

import lombok.NonNull;
import tictactoe.model.Board;
import tictactoe.model.Move;

public interface GameWinningStrategy {
    boolean evaluate(@NonNull final Board board, @NonNull final  Move move);

    void handleUndo(@NonNull final Board board, @NonNull final  Move move);
}
