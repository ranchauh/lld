package tictactoe.strategy.gamewinningstrategy;

import lombok.NonNull;
import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements GameWinningStrategy {

    private final Map<Symbol, Integer> leftDiagonalMap = new HashMap<>();
    private final Map<Symbol, Integer> rightDiagonalMap = new HashMap<>();

    @Override
    public boolean evaluate(@NonNull final Board board, @NonNull final Move move) {
        int row = move.getRow();
        int col = move.getCol();
        int size = board.getSize();

        Symbol symbol = move.getSymbol();
        boolean isWon = false;
        if(row == col) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.getOrDefault(symbol, 0) + 1);
            isWon = rightDiagonalMap.get(symbol) == size;
        }

        if(row + col == size - 1) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.getOrDefault(symbol, 0) + 1);
            isWon = leftDiagonalMap.get(symbol) == size;
        }

        return isWon;
    }

    @Override
    public void handleUndo(@NonNull final Board board, @NonNull Move move) {
        int row = move.getRow();
        int col = move.getCol();
        int size = board.getSize();

        Symbol symbol  = move.getSymbol();
        if(row == col) {
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol) - 1);
        }
        if(row + col == size - 1) {
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol) - 1);
        }
    }


}
