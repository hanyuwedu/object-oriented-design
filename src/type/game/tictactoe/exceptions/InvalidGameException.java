package type.game.tictactoe.exceptions;

public class InvalidGameException extends RuntimeException {
    public InvalidGameException() {
        super("This game is not valid!");
    }

    public InvalidGameException(String message) {
        super(message);
    }
}
