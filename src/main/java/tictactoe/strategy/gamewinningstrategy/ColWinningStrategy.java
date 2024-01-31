package tictactoe.strategy.gamewinningstrategy;

import lombok.NonNull;
import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, Map<Symbol, Integer>> colMaps = new HashMap<>();

    @Override
    public boolean evaluate(@NonNull final Board board, @NonNull final Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getSymbol();

        Map<Symbol, Integer> map = colMaps.getOrDefault(col, new HashMap<>());
        map.put(symbol, map.getOrDefault(symbol, 0) + 1);

        colMaps.put(col, map);

        return map.get(symbol) == board.getSize();
    }

    @Override
    public void handleUndo(@NonNull final Board board, @NonNull Move move) {
        int col = move.getCol();
        Map<Symbol, Integer> colMap = colMaps.get(col);
        colMap.put(move.getSymbol(), colMap.get(move.getSymbol()) - 1);
    }

}
