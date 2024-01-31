package tictactoe.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Cell {
    private int row;
    private int col;

    private Player player;
    private CellState cellState;
}
