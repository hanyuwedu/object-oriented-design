package type.game.tictactoe.v1;

import type.game.tictactoe.v1.exceptions.InvalidGameException;
import type.game.tictactoe.v1.exceptions.NotPlayerTurnException;

public class TicTacToe {
    private Player tic, tac;
    private Player currentPlayer;
    private Character signature;
    private Board board;
    private int step;

    private Player[] playerOrder = new Player[2];
    private Character[] signatures = {'O', 'X'};

    public TicTacToe() { }

    public void sit(Player player) {
        if (this.tic == null) {
            this.tic = player;
            /**
             * 双向关联的设计
             */
            player.setTicTacToe(this);
        } else if (this.tac == null && player != this.tic) {
            this.tac = player;
            player.setTicTacToe(this);
        } else if (this.tic == player) {
            throw new InvalidGameException("Players cannot play with himself!");
        } else {
            throw new InvalidGameException("Room is full.");
        }
    }

    public void startGame() {
        if (this.tic == null || this.tac == null) {
            throw new InvalidGameException("Game has to be played by 2 players");
        }
        this.initialize();
    }

    public void initialize() {
        System.out.println("Resetting...");

        playerOrder[0] = this.tic;
        playerOrder[1] = this.tac;

        this.step = 1;
        this.currentPlayer = this.playerOrder[step % 2];
        this.board = new Board();
        this.signature = this.signatures[step % 2];

        System.out.println("Player " + this.currentPlayer.getName() + " will be moving first.");
    }

    public void move(int row, int col, Player player) {
        if (player != currentPlayer) {
            throw new NotPlayerTurnException();
        }

        this.board.move(row, col, this.signature);

        Result currentResult = this.board.checkResult();
        if (currentResult.equals(Result.WIN) || currentResult.equals(Result.DRAW)) {
            this.summary();
        } else {
            this.step++;
            this.currentPlayer = playerOrder[step % 2];
            this.signature = signatures[step % 2];
        }
    }

    public void summary() {
        if (this.board.checkResult().equals(Result.WIN)) {
            this.currentPlayer.win();
            System.out.println("Player " + this.currentPlayer.getName()
                    + " won! His current score is " + this.currentPlayer.getWin());
            System.out.println("This game ends as: ");
            this.board.printBoard();

            if (this.currentPlayer.getWin() == 2) {
                System.out.println("Player " + this.currentPlayer.getName() + " reached 2 games!");
            } else {
                this.initialize();
            }
        } else if (this.board.checkResult().equals(Result.DRAW)) {
            System.out.println("Game is draw.");
            System.out.println("This game ends as: ");
            this.board.printBoard();

            this.initialize();
        }
    }
}
