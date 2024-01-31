package tictactoe.strategy.gamewinningstrategy;

import lombok.NonNull;
import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, Map<Symbol, Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean evaluate(@NonNull final Board board,@NonNull final Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getSymbol();

        Map<Symbol, Integer> map = rowMaps.getOrDefault(row, new HashMap<>());
        map.put(symbol, map.getOrDefault(symbol, 0) + 1);

        rowMaps.put(row, map);

        return map.get(symbol) == board.getSize();
    }

    @Override
    public void handleUndo(@NonNull final Board board, @NonNull Move move) {
        int row = move.getRow();
        Map<Symbol, Integer> rowMap = rowMaps.get(row);
        rowMap.put(move.getSymbol(), rowMap.get(move.getSymbol()) - 1);
    }
}
