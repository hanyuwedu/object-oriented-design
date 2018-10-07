package type.game.blackjack.v1;

import type.game.tictactoe.v1.exceptions.InvalidGameException;

public class Player {
    private String name;
    private boolean isOpen;
    private Hand hand;
    private Board board;

    public Player(String name) {
        this.name = name;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void initialize() {
        this.isOpen = true;
        this.hand = new Hand();
    }

    public void stop() {
        this.isOpen = false;
    }

    public void toss() {
        if (!this.isOpen) {
            throw new InvalidGameException("Current player has already close. Cannot toss anymore");
        }

        this.hand.toss(this.board.getNext());
    }

    public void printDetail() {
        System.out.println("Player " + this.name + " is " + (isOpen ? "open." : "closed."));
        System.out.println("His " + this.hand.toString());
    }

    public boolean isOpen() {
        return isOpen;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return this.hand.count();
    }
}
