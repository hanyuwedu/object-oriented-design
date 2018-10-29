package type.game.tictactoe.v2.game;

import type.game.tictactoe.v2.exceptions.InvalidMoveException;

import java.util.*;

public class Board {
    private Character[][] board;
    private final int SIZE;

    public Board(final int size) {
        this.board = new Character[size][size];
        this.SIZE = size;
    }

    /**
     * 在棋盘上上某个位置下取
     *
     * @param row 目标位置的#row
     * @param col 目标位置的#col
     * @param signature 下取的标记
     */
    public void move(int row, int col, Character signature) {
        if (row < 0 || col < 0 || row >= this.SIZE || col >= this.SIZE) {
            throw new InvalidMoveException("This move is out of board.");
        }

        if (this.board[row][col] != null) {
            throw new InvalidMoveException("This current position is already occupied");
        }

        this.board[row][col] = signature;
    }

    /**
     * 查看当前回合的结果
     *
     * @return 当前回合的结果
     */
    public Result checkResult() {
        Integer[][] lines = this.getLines();

        for (Integer[] line : lines) {
            boolean hasEmpty = false;
            Set<Character> characters = new HashSet<>();
            for (Integer pos : line) {
                Character character = this.getCharacter(pos);
                if (character == null) {
                    hasEmpty = true;
                    break;
                }
                characters.add(character);
            }

            if (!hasEmpty && characters.size() == 1) {
                return Result.WIN;
            }
        }

        for (Character[] row : this.board) {
            for (Character character : row) {
                if (character == null) {
                    return Result.UNKNOWN;
                }
            }
        }

        return Result.DRAW;
    }

    private Integer[][] getLines() {
        List<Integer[]> lines = new ArrayList<>();

        /*
         * Horizontal
         */
        for (int i = 0; i <= this.SIZE - 1; i++) {
            Integer[] line = new Integer[this.SIZE];
            for (int j = 0; j <= this.SIZE - 1; j++) {
                line[j] = i * this.SIZE + j;
            }
            lines.add(line);
        }

        /*
         * Vertical
         */
        for (int j = 0; j <= this.SIZE - 1; j++) {
            Integer[] line = new Integer[this.SIZE];
            for (int i = 0; i <= this.SIZE - 1; i++) {
                line[i] = i * this.SIZE + j;
            }
            lines.add(line);
        }

        /*
         * Diagonal
         */
        Integer[] line_slash = new Integer[this.SIZE];
        for (int i = 0; i <= this.SIZE - 1; i++) {
            int j = i;
            line_slash[i] = i * this.SIZE + j;
        }
        lines.add(line_slash);

        Integer[] line_backslash = new Integer[this.SIZE];
        for (int i = 0; i <= this.SIZE - 1; i++) {
            int j = this.SIZE - i - 1;
            line_backslash[i] = i * this.SIZE + j;
        }
        lines.add(line_backslash);

        return lines.toArray(new Integer[lines.size()][SIZE]);
    }

    public void print() {
        for (int i = 0; i <= this.SIZE - 1; i++) {
            System.out.println(Arrays.toString(this.board[i]));
        }
    }

    private Character getCharacter(int pos) {
        int row = pos / this.SIZE;
        int col = pos % this.SIZE;

        return this.board[row][col];
    }
}
