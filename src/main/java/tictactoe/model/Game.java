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

    public void validateGame() throws InvalidGameStateException {
        if(this.gameState != GameState.IN_PROGRESS) {
            throw new InvalidGameStateException("Game is not in progress");
        }
    }

    public void makeMove(int row, int col) throws InvalidGameStateException, InvalidMoveException {
        this.validateGame();
        Player player = this.getPlayers().get(this.getNextMovePlayerIndex());
        Cell cell = this.getBoard().makeMove(row, col, player);
        Move move = new Move(cell, this.getNextMovePlayerIndex(), this.getGameState(), false);
        this.getMoves().add(move);
        // check winner
        for(GameWinningStrategy winningStrategy : this.getWinningStrategies()) {
            if(winningStrategy.evaluate(this.getBoard(), move)) {
                this.setWinner(player);
                this.setGameState(GameState.ENDED);
                return;
            }
        }
        int nextPlayerIndex = this.getNextMovePlayerIndex() + 1;
        this.setNextMovePlayerIndex(nextPlayerIndex % this.getPlayers().size());
    }

    public void undo() {
        int size = this.getMoves().size();
        if(size == 0) {
            return;
        }
        Move lastMove = this.moves.get(size - 1);
        lastMove.setUndo(true);
        this.getBoard().getBoard()
                .get(lastMove.getRow())
                .get(lastMove.getCol())
                .setCellState(CellState.EMPTY);
        this.setNextMovePlayerIndex(lastMove.getPlayerIndex());
        this.setGameState(lastMove.getGameState());
        // update winning strategy
        for(GameWinningStrategy winningStrategy : this.getWinningStrategies()) {
            if(winningStrategy.evaluate(this.getBoard(), lastMove)) {
                this.setWinner(lastMove.getCell().getPlayer());
                this.setGameState(GameState.ENDED);
                return;
            }
        }
        this.moves.remove(lastMove);
        this.setWinner(null);
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
