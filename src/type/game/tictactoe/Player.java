package type.game.tictactoe;

public class Player {
    private String name;
    private int win;
    private TicTacToe ticTacToe;

    public Player(String name) {
        this.name = name;
        this.win = 0;
    }

    /**
     * 双向关联的设计
     * @param ticTacToe 调用者
     */
    public void setTicTacToe(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public void move(int col, int row) {
        this.ticTacToe.move(col, row, this);
    }

    public void win() {
        this.win++;
    }

    public String getName() {
        return this.name;
    }

    public int getWin() {
        return this.win;
    }

    @Override
    public String toString() {
        return this.name + ", score: " + this.win;
    }
}
