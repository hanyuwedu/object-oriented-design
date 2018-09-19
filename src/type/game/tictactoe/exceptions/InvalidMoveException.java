package type.game.tictactoe.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException() {
        this("This move is not valid!");
    }

    public InvalidMoveException(String message) {
        super(message);
    }
}
