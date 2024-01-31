package tictactoe.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@Builder
public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;

    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%s, where do you want to make a move: %n", this.name);
        System.out.print("Row: ");
        int row = scanner.nextInt();
        System.out.print("Col: ");
        int col = scanner.nextInt();
        return new Move(Cell.builder()
                .row(row)
                .col(col)
                .player(this)
                .build());
    }

    @Override
    public String toString() {
        return String.format("%s", this.name);
    }
}
