package type.game.tictactoe;

import type.game.tictactoe.exceptions.InvalidMoveException;

import java.util.Arrays;

public class Board {
    private Character[][] board;

    public Board() {
        this.board = new Character[3][3];
    }

    public void move(int row, int col, Character signature) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            throw new InvalidMoveException("Current move is out of board");
        }

        if (this.board[row][col] != null) {
            throw new InvalidMoveException("Current position is occupied!");
        }

        this.board[row][col] = signature;
    }

    public Result checkResult() {
        int[][] lines = getLines();
        for (int[] line : lines) {
            Character char0, char1, char2;

            char0 = this.board[line[0] / 3][line[0] % 3];
            char1 = this.board[line[1] / 3][line[1] % 3];
            char2 = this.board[line[2] / 3][line[2] % 3];

            if (char0 == null || char1 == null || char2 == null) {
                continue;
            }

            if (char0 == char1 && char0 == char2) {
                return Result.WIN;
            }
        }

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (this.board[i][j] == null) {
                    return Result.UNKOWN;
                }
            }
        }

        return Result.DRAW;
    }

    public void printBoard() {
        for (int i = 0; i <= 2; i++) {
            System.out.println(Arrays.toString(this.board[i]));
        }
    }

    private static int[][] getLines() {
        int[][] lines = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        return lines;
    }
}
