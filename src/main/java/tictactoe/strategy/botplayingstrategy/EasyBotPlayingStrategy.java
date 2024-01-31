package tictactoe.strategy.botplayingstrategy;

import tictactoe.model.Board;
import tictactoe.model.Cell;
import tictactoe.model.CellState;
import tictactoe.model.Move;

import java.util.List;
import java.util.Optional;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        for (List<Cell> cells : board.getBoard()) {
            for (Cell cell : cells) {
                if(cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell);
                }
            }
        }
        return new Move(Cell.builder()
                .row(board.getSize())
                .col(board.getSize())
                .build());
    }
}
