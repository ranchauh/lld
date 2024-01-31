package tictactoe.model;

import lombok.Getter;
import lombok.Setter;
import tictactoe.exception.InvalidBotCountException;
import tictactoe.exception.InvalidGameStateException;
import tictactoe.exception.InvalidMoveException;
import tictactoe.exception.InvalidNumberOfPlayers;
import tictactoe.strategy.gamewinningstrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextMovePlayerIndex;
    private GameState gameState;
    private List<Move> moves;
    private List<GameWinningStrategy> winningStrategies;

    private Game(int size, List<Player> players, List<GameWinningStrategy> winningStrategies) {
        this.board = new Board(size);
        this.players = players;
        this.winningStrategies = winningStrategies;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.winner = null;
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean isInvalidMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        return row < 0 || row >= this.getBoard().getSize()
                || col < 0 || col >= this.getBoard().getSize()
                || this.getBoard().getBoard().get(row).get(col).getCellState() != CellState.EMPTY;
    }

    private boolean isWinningMove(Move move) {
        for(GameWinningStrategy winningStrategy : this.getWinningStrategies()) {
            if(winningStrategy.evaluate(this.getBoard(), move)) {
                return true;
            }
        }
        return false;
    }

    public void makeMove() throws InvalidGameStateException, InvalidMoveException {
        Player player = this.getPlayers().get(this.getNextMovePlayerIndex());
        Move move = player.makeMove(this.board);
        if(isInvalidMove(move)) {
            throw new InvalidMoveException(String.format("Invalid move at: [%d,%d]", move.getRow(), move.getCol()));
        }

        Cell boardCell = this.getBoard().getBoard().get(move.getRow()).get(move.getCol());
        boardCell.setPlayer(player);
        boardCell.setCellState(CellState.FILLED);
        move = new Move(boardCell);

        this.getMoves().add(move);
        int nextPlayerIndex = this.getNextMovePlayerIndex() + 1;
        this.setNextMovePlayerIndex(nextPlayerIndex % this.getPlayers().size());
        if(isWinningMove(move)) {
            this.setWinner(player);
            this.setGameState(GameState.ENDED);
        } else if(isGameDrawn()) {
            this.setGameState(GameState.DRAW);
        }
    }

    private boolean isGameDrawn() {
        return this.getMoves().size() == this.getBoard().getSize() * this.getBoard().getSize();
    }

    public void undo() {
        int size = this.getMoves().size();
        if(size == 0) {
            System.out.println("Nothing to undo");
            return;
        }
        Move lastMove = this.moves.get(size - 1);
        this.getBoard().getBoard()
                .get(lastMove.getRow())
                .get(lastMove.getCol())
                .setCellState(CellState.EMPTY);
        int nextPlayerIndex = this.getNextMovePlayerIndex() - 1;
        nextPlayerIndex = (nextPlayerIndex + this.getPlayers().size()) % this.getPlayers().size();
        this.setNextMovePlayerIndex(nextPlayerIndex);
        this.moves.remove(lastMove);
        // update winning strategies
        this.updateWinningStrategies(lastMove);
    }

    private void updateWinningStrategies(Move move) {
        for(GameWinningStrategy winningStrategy : this.getWinningStrategies()) {
            winningStrategy.handleUndo(this.getBoard(), move);
        }
    }

    public static class Builder {
        private int size;
        private List<Player> players;
        private List<GameWinningStrategy> winningStrategies;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder winningStrategies(List<GameWinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private boolean validateBotCount() {
            return this.players.stream()
                    .filter(p -> p.getPlayerType() == PlayerType.BOT)
                    .count() <= 1;
        }

        private boolean validate() throws InvalidNumberOfPlayers, InvalidBotCountException {
            if(players.size() != size - 1) {
                throw new InvalidNumberOfPlayers("Number of players should be " + (size - 1));
            }
            if(!validateBotCount()) {
                throw new InvalidBotCountException("Bot count should be less than or equal to 1");
            }
            // add more validations as needed
            return true;
        }

        public Game build() throws InvalidBotCountException, InvalidNumberOfPlayers {
            validate();
            return new Game(this.size, this.players, this.winningStrategies);
        }
    }


}
