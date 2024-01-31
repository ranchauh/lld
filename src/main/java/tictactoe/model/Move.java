package tictactoe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Move {
    @NonNull private Cell cell;

    public int getRow() {
        return cell.getRow();
    }

    public int getCol() {
        return cell.getCol();
    }

    public Symbol getSymbol() {
        return this.cell.getPlayer().getSymbol();
    }
}
