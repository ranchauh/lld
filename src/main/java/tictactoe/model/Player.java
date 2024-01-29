package tictactoe.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
}
