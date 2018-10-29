package type.game.tictactoe.v2.game;

import type.game.tictactoe.v2.Player;
import type.game.tictactoe.v2.exceptions.InvalidMoveException;

import java.util.List;
import java.util.Random;

public class Game {
    private final int SIZE = 3;
    private final Character[] DEFAULT_SIGNATURE = {'#', 'O'};

    private List<Player> players;
    private Board board;
    private Random random;

    private Player currentPlayer;
    private Character currentSignature;
    private int steps;

    public Game(List<Player> players, Random random) {
        this.players = players;
        this.random = random;

        System.out.println("Starting a new game...");
        this.board = new Board(this.SIZE);
        this.currentPlayer = this.players.get(this.random.nextInt(players.size()));
        this.steps = 0;
        this.currentSignature = this.DEFAULT_SIGNATURE[this.steps];

        System.out.println("Player " + this.currentPlayer + " moves first.");
    }


    /**
     * 切换游戏回合
     */
    private void changeTurn() {
        this.steps++;
        this.currentSignature = this.DEFAULT_SIGNATURE[steps % this.players.size()];
        this.currentPlayer = this.players.get((players.indexOf(currentPlayer) + 1) % this.players.size());
    }

    /**
     * 在棋盘上上某个位置下取
     *
     * @param row 目标位置的#row
     * @param col 目标位置的#col
     * @param player 当前回合的执棋手
     * @return 游戏结果
     */
    public Result move(int row, int col, Player player) {
        if (player != this.currentPlayer) {
            throw new InvalidMoveException("Not current player's turn");
        }

        this.board.move(row, col, this.currentSignature);
        Result result = this.board.checkResult();

        if (!result.equals(Result.UNKNOWN)) {
            this.summary();
        } else {
            this.changeTurn();
        }

        return result;
    }

    /**
     * 总结游戏结果
     */
    public void summary() {
        Result result = this.board.checkResult();
        if (result.equals(Result.WIN)) {
            System.out.println("Player " + this.currentPlayer.getName() + " won!");
            System.out.println("This game ends as: ");
            this.board.print();
        } else if (result.equals(Result.DRAW)) {
            System.out.println("Game is draw.");
            System.out.println("This game ends as: ");
            this.board.print();
        }
    }
}
