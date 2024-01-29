package tictactoe.exception;

public class InvalidGameStateException extends Exception {
    public InvalidGameStateException(String message) {
        super(message);
    }
}
