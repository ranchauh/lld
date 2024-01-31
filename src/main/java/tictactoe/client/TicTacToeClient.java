package tictactoe.client;


import tictactoe.controller.GameController;
import tictactoe.exception.InvalidBotCountException;
import tictactoe.exception.InvalidGameStateException;
import tictactoe.exception.InvalidMoveException;
import tictactoe.exception.InvalidNumberOfPlayers;
import tictactoe.model.*;
import tictactoe.strategy.gamewinningstrategy.ColWinningStrategy;
import tictactoe.strategy.gamewinningstrategy.DiagonalWinningStrategy;
import tictactoe.strategy.gamewinningstrategy.GameWinningStrategy;
import tictactoe.strategy.gamewinningstrategy.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeClient {
    public static void main(String[] args) throws InvalidBotCountException, InvalidNumberOfPlayers, InvalidMoveException, InvalidGameStateException {
        GameController gameController = new GameController();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter game dimension:");
        int dimension = scanner.nextInt();
        System.out.print("Want to play with a bot (y/n): ");
        Player player1 = Player.builder()
                        .id(1)
                        .name("Player-1")
                        .symbol(new Symbol('X'))
                        .build();
        Player player2 = Player.builder()
                        .id(2)
                        .name("Player-2")
                        .symbol(new Symbol('O'))
                        .build();
        if(scanner.next().equalsIgnoreCase("y")) {
            player2 = new Bot(2, "Bot", new Symbol('O'));
        }
        List<GameWinningStrategy> winningStrategy = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinningStrategy()
        );
        Game game = gameController.startGame(dimension, List.of(player1, player2), winningStrategy);
        gameController.displayBoard(game);
        while(game.getGameState() == GameState.IN_PROGRESS) {
            System.out.print("Want to undo (y/n)? ");
            if(scanner.next().equalsIgnoreCase("y")) {
                gameController.undo(game);
                gameController.displayBoard(game);
                continue;
            }
            try {
                gameController.makeMove(game);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
            }
            gameController.displayBoard(game);
        }
        // Game over
        // check winner or draw
        if(game.getGameState() == GameState.ENDED) {
            System.out.println("Game Over. Winner is: " + game.getWinner());
        } else if(game.getGameState() == GameState.DRAW) {
            System.out.println("Game drawn");
        }
    }
}
