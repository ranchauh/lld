package tictactoe.strategy.gamewinningstrategy;

import tictactoe.model.Board;
import tictactoe.model.Game;
import tictactoe.model.Move;
import tictactoe.model.Symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, Map<Symbol, Integer>> rowMap = new HashMap<>();

    @Override
    public boolean evaluate(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol symbol = move.getSymbol();
        int update = move.isUndo() ? -1 : 1;

        Map<Symbol, Integer> map = rowMap.getOrDefault(row, new HashMap<>());
        map.put(symbol, map.getOrDefault(symbol, 0) + update);

        rowMap.put(row, map);

        return map.get(symbol) == board.getSize();
    }
}
