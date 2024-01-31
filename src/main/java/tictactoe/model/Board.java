package tictactoe.model;

import lombok.Getter;
import lombok.Setter;

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
                this.board.get(i).add(Cell.builder()
                                .row(i)
                                .col(j)
                                .cellState(CellState.EMPTY)
                        .build());
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
}
