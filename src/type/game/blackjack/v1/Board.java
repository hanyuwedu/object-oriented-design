package type.game.blackjack.v1;

import type.game.blackjack.v1.exceptions.InvalidGameException;
import type.game.blackjack.v1.exceptions.InvalidTossException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board {
    private Dealer dealer;
    private List<Player> players;
    private Stack<Card> cardStack;

    public Board() {
        this.players = new ArrayList<>();
    }

    public Card getNext() {
        if (this.cardStack == null || this.cardStack.isEmpty()) {
            throw new InvalidTossException("Deck is empty!");
        }
        return this.cardStack.pop();
    }

    public void sit(Player player) {
        if (this.players.size() >= 3) {
            throw new InvalidGameException("Game is full!");
        }

        if (this.players.contains(player)) {
            throw new InvalidGameException("Player is already here!");
        }


        player.setBoard(this);
        this.players.add(player);
    }

    public void initialize() {
        this.dealer = new Dealer();
        this.cardStack = getRandomeStack();
    }

    public void startGame() {
        this.initialize();
        if (this.players == null || this.players.isEmpty()) {
            throw new InvalidGameException("At least one player is required for this game");
        }

        for (Player player : players) {
            player.initialize();
            player.toss();
            player.toss();
        }
    }

    private Stack<Card> getRandomeStack() {
        return Utility.getRandomStack(3, 15);
    }

    public void summary() {
        for (Player player : players) {
            if (player.isOpen()) {
                throw new InvalidGameException("Player " + player.getName() + " is still open!");
            }
        }

        int dealerValue = this.dealer.toss();
        System.out.println("Dealer has " + dealerValue);
        for (Player player : players) {
            player.printDetail();
            if (player.getPoint() <= dealerValue || player.getPoint() > 21) {
                System.out.println("He lost!");
            } else {
                System.out.println("He won!");
            }
        }

        this.initialize();
    }

    public void printDeck() {
        System.out.println(this.cardStack.toString());
    }
}
