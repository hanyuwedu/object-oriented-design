package jiuzhang.tictactoe;

public class DesignTicTacToe {
    public class TicTacToe {
        private char[][] board;
        private char currentPlayerMark;
        private boolean gameEnd;

        public TicTacToe() {
            this.initialize();
        }

        public char getCurrentPlayer() {
            return this.currentPlayerMark;
        }

        public void initialize() {
            this.currentPlayerMark = 'x';
            this.board = new char[3][3];
            this.gameEnd = false;
        }

        private boolean isBoardFull() {
            for (char[] cols : board) {
                for (char place : cols) {
                    if (place != 'x' && place != 'o') {
                        return false;
                    }
                }
            }

            this.gameEnd = true;
            return true;
        }

        private void changePlayer() {
            if (currentPlayerMark == 'x') {
                this.currentPlayerMark = 'o';
            } else if (currentPlayerMark == 'o') {
                this.currentPlayerMark = 'x';
            } else {
                this.currentPlayerMark = 'x';
            }
        }

        // true means this move wins the game, false means otherwise
        public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {
            if (this.gameEnd) {
                throw new GameEndException();
            }

            if (this.board[row][col] == 'x' || this.board[row][col] == 'o') {
                throw new AlreadyTakenException();
            }

            this.board[row][col] = this.currentPlayerMark;

            if (this.win()) {
                this.initialize();
                this.gameEnd = true;
                return true;
            } else {
                this.changePlayer();
            }

            return false;
        }

        private boolean win() {
            if ((this.board[0][0] == 'x' || this.board[0][0] == 'o') && this.board[0][0] == this.board[0][1] && this.board[0][0] == this.board[0][2]) {
                return true;
            }

            if ((this.board[1][0] == 'x' || this.board[1][0] == 'o') && this.board[1][0] == this.board[1][1] && this.board[1][0] == this.board[1][2]) {
                return true;
            }

            if ((this.board[2][0] == 'x' || this.board[2][0] == 'o') && this.board[2][0] == this.board[2][1] && this.board[2][0] == this.board[2][2]) {
                return true;
            }

            if ((this.board[0][0] == 'x' || this.board[0][0] == 'o') && this.board[0][0] == this.board[1][0] && this.board[0][0] == this.board[2][0]) {
                return true;
            }

            if ((this.board[0][1] == 'x' || this.board[0][1] == 'o') && this.board[0][1] == this.board[1][1] && this.board[0][1] == this.board[2][1]) {
                return true;
            }

            if ((this.board[0][2] == 'x' || this.board[0][2] == 'o') && this.board[0][2] == this.board[1][2] && this.board[0][2] == this.board[2][2]) {
                return true;
            }

            if ((this.board[0][0] == 'x' || this.board[0][0] == 'o') && this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2]) {
                return true;
            }

            if ((this.board[0][2] == 'x' || this.board[0][2] == 'o') && this.board[0][2] == this.board[1][1] && this.board[0][2] == this.board[2][0]) {
                return true;
            }

            return false;
        }
    }


    class GameEndException extends Exception{
        public GameEndException()
        {
            super("Game has been ended, cannot make any more moves");
        }
    }

    class AlreadyTakenException extends Exception {
        public AlreadyTakenException()
        {
            super("This place has been taken");
        }
    }
}
