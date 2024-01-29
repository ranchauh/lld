package tictactoe.strategy.gamewinningstrategy;

import tictactoe.model.Board;
import tictactoe.model.Move;
import tictactoe.model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements GameWinningStrategy {

    private final Map<Integer, Map<Symbol, Integer>> colMap = new HashMap<>();

    @Override
    public boolean evaluate(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getSymbol();
        int update = move.isUndo() ? -1 : 1;

        Map<Symbol, Integer> map = colMap.getOrDefault(col, new HashMap<>());
        map.put(symbol, map.getOrDefault(symbol, 0) + update);

        colMap.put(col, map);

        return map.get(symbol) == board.getSize();
    }

}
