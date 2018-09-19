package type.game.blackjack.exceptions;

public class InvalidGameException extends RuntimeException {
    public InvalidGameException() {
        this("Game is not over yet!");
    }

    public InvalidGameException(String message){
        super(message);
    }
}
