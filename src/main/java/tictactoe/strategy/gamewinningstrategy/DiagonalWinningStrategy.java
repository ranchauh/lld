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
        int update = move.isUndo() ? -1 : 1;

        Symbol symbol = move.getSymbol();
        if(row == (board.getSize() - (col + 1)) && checkDiagonal(leftDiagonalMap, size, symbol, update)) {
            return true;
        } else return row == col && checkDiagonal(rightDiagonalMap, size, symbol, update);
    }

    private boolean checkDiagonal(Map<Symbol, Integer> map, int size, Symbol symbol, int update) {
        map.put(symbol, map.getOrDefault(symbol, 0) + update);
        return map.get(symbol) == size;
    }



}
