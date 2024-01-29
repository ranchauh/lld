package tictactoe.client;


import lombok.NonNull;
import tictactoe.controller.GameController;
import tictactoe.exception.InvalidBotCountException;
import tictactoe.exception.InvalidGameStateException;
import tictactoe.exception.InvalidMoveException;
import tictactoe.exception.InvalidNumberOfPlayers;
import tictactoe.model.Game;
import tictactoe.model.Player;
import tictactoe.model.Symbol;
import tictactoe.strategy.gamewinningstrategy.ColWinningStrategy;
import tictactoe.strategy.gamewinningstrategy.DiagonalWinningStrategy;
import tictactoe.strategy.gamewinningstrategy.GameWinningStrategy;
import tictactoe.strategy.gamewinningstrategy.RowWinningStrategy;

import java.util.List;
import java.util.Scanner;

public class TicTacToeClient {
    public static void main(String[] args) throws InvalidBotCountException, InvalidNumberOfPlayers, InvalidMoveException, InvalidGameStateException {
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter game dimension:");
        int dimension = 3;
        List<Player> players = List.of(
                Player.builder()
                        .id(1)
                        .name("Player-1")
                        .symbol(new Symbol('X'))
                        .build(),
                Player.builder()
                        .id(2)
                        .name("Player-2")
                        .symbol(new Symbol('O'))
                        .build()
        );
        List<GameWinningStrategy> winningStrategy = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );
        Game game = gameController.startGame(dimension, players, winningStrategy);
        gameController.displayBoard(game);
        // make first move
        gameController.makeMove(game, 1, 1);
        System.out.printf("After move: [%d, %d]%n", 1, 1);
        gameController.displayBoard(game);

        // make move at 2, 0
        gameController.makeMove(game, 2, 0);
        System.out.printf("After move: [%d, %d]%n", 2, 0);
        gameController.displayBoard(game);
        // make move at 1, 0
        gameController.makeMove(game, 1, 0);
        System.out.printf("After move: [%d, %d]%n", 1, 0);
        gameController.displayBoard(game);

        // make move at 2, 2
        gameController.makeMove(game, 2, 2);
        System.out.printf("After move: [%d, %d]%n", 2, 2);
        gameController.displayBoard(game);

        // make move at 2, 2
        gameController.makeMove(game, 1, 2);
        System.out.printf("After move: [%d, %d]%n", 1, 2);
        gameController.displayBoard(game);

        System.out.println(gameController.checkStatus(game));
        // undo last 5 operation
        for(int i=0; i<5; i++) {
            gameController.undo(game);
            System.out.print("After undo:");
            gameController.displayBoard(game);
        }
        System.out.println(gameController.checkStatus(game));

        for(int i=0; i<dimension; i++) {
            // make move at i, i
            gameController.makeMove(game, i, i);
            System.out.printf("After move: [%d, %d]%n", i, i);
            gameController.displayBoard(game);
            System.out.println(gameController.checkStatus(game));

            gameController.makeMove(game, i, i+1);
            System.out.printf("After move: [%d, %d]%n", i, i+1);
            gameController.displayBoard(game);
            System.out.println(gameController.checkStatus(game));
        }
    }
}
