package tictactoe.controller;

import lombok.NonNull;
import tictactoe.exception.InvalidBotCountException;
import tictactoe.exception.InvalidGameStateException;
import tictactoe.exception.InvalidMoveException;
import tictactoe.exception.InvalidNumberOfPlayers;
import tictactoe.model.*;
import tictactoe.strategy.gamewinningstrategy.GameWinningStrategy;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Controller class to expose operations for game to the client.
 */
public class GameController {

    public Game startGame(@NonNull final int size,
                          @NonNull final List<Player> players,
                          @NonNull final List<GameWinningStrategy> winningStrategies) throws InvalidBotCountException, InvalidNumberOfPlayers {
       return Game.builder()
               .size(size)
               .players(players)
               .winningStrategies(winningStrategies)
               .build();
    }

    public void makeMove(Game game) throws InvalidMoveException, InvalidGameStateException {
        game.makeMove();
    }

    public GameState checkStatus(Game game) {
        return game.getGameState();
    }

    public Optional<Player> getWinner(Game game) {
        return Optional.ofNullable(game.getWinner());
    }

    public void undo(Game game) {
        game.undo();
    }

    public void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }
}
