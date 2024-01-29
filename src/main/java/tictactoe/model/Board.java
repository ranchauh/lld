package tictactoe.model;

import lombok.Getter;
import lombok.Setter;
import tictactoe.exception.InvalidMoveException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        this.board = new ArrayList<>();
        for(int i=0; i<size; i++) {
            this.board.add(new ArrayList<>());
            for(int j=0; j<size; j++) {
                this.board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoard() {
        System.out.println();
        for(List<Cell> row : this.board) {
            for(Cell c : row) {
                System.out.print("|");
                if(c.getCellState() == CellState.EMPTY) {
                    System.out.print("   ");
                } else {
                    System.out.print(" ");
                    System.out.print(c.getPlayer().getSymbol().getSymbol());
                    System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }

    public Cell makeMove(int row, int col, Player player) throws InvalidMoveException {
        if(this.isInvalidMove(row, col)) {
            throw new InvalidMoveException(String.format("Invalid move at cell [%d,%d]", row, col));
        }
        Cell cell = this.getBoard().get(row).get(col);
        cell.setPlayer(player);
        cell.setCellState(CellState.FILLED);
        return cell;
    }

    private boolean isInvalidMove(int row, int col) {
        return row < 0 || row >= this.getSize()
                || col < 0 || col >= this.getSize()
                || this.getBoard().get(row).get(col).getCellState() != CellState.EMPTY;
    }
}
