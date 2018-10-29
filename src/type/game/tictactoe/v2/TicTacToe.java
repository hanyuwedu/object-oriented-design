package type.game.tictactoe.v2;

import type.game.tictactoe.v2.exceptions.InvalidGameException;
import type.game.tictactoe.v2.exceptions.InvalidMoveException;
import type.game.tictactoe.v2.game.Game;
import type.game.tictactoe.v2.game.Result;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TicTacToe {
    private final int PLAYERS = 2;
    private final int GOAL = 2;

    private final Random random = new Random(2);

    private Map<Player, Integer> scores;
    private List<Player> players;
    private Game game;

    public TicTacToe(List<Player> players) {
        if (players == null || players.size() != this.PLAYERS) {
            throw new InvalidGameException("players is not matched");
        }

        this.scores = players.stream().collect(Collectors.toMap(
                Function.identity(), player -> 0));
        this.players = players;
        this.startGame();
    }

    /**
     * 开始一局新游戏
     */
    public void startGame() {
        this.game = new Game(this.players, this.random);
    }


    /**
     * 来自玩家的行棋请求
     *
     * @param row 目标位置的#row
     * @param col 目标位置的#col
     * @param player 请求玩家
     */
    public void move(int row, int col, Player player) {
        if (this.game == null) {
            throw new InvalidMoveException("Game has not been setup yet");
        }

        Result result = this.game.move(row, col, player);
        if (result.equals(Result.WIN)) {
            this.summary(player);
        } else if (result.equals(Result.DRAW)) {
            this.summary(null);
        }
    }

    /**
     * 总结当前比赛状态
     *
     * @param winner 当前游戏胜者
     */
    public void summary(Player winner) {
        if (winner != null) {
            this.scores.put(winner, this.scores.get(winner) + 1);
            System.out.println(winner + "'s current score is " + this.scores.get(winner));

            if (this.scores.get(winner) == GOAL) {
                System.out.println("Player " + winner.getName() + " reached " + this.GOAL + " games!");
                this.game = null;
            } else {
                this.startGame();
            }
        } else {
            this.startGame();
        }
    }
}
