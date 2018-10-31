package type.game.blackjack.v2.exceptions;

public class InvalidGameException extends RuntimeException {
    public InvalidGameException() {
        this("Game is not over yet!");
    }

    public InvalidGameException(String message){
        super(message);
    }
}
