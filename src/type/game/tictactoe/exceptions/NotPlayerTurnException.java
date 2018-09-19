package type.game.tictactoe.exceptions;

public class NotPlayerTurnException extends RuntimeException {
    public NotPlayerTurnException() {
        this("Not current player's turn");
    }

    public NotPlayerTurnException(String message) {
        super(message);
    }
}
