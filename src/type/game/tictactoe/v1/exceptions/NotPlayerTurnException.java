package type.game.tictactoe.v1.exceptions;

public class NotPlayerTurnException extends RuntimeException {
    public NotPlayerTurnException() {
        this("Not current player's turn");
    }

    public NotPlayerTurnException(String message) {
        super(message);
    }
}
