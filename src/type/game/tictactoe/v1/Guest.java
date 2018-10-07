package type.game.tictactoe.v1;

public class Guest {
    public static void main(String[] args) {
//        checkBoard();
        game1();
    }

    private static void game1() {
        Player red = new Player("red");
        Player black = new Player("black");
        TicTacToe game1 = new TicTacToe();
        game1.sit(red);
        game1.sit(black);

        game1.startGame();
        black.move(1, 1);
        red.move(0, 2);
        black.move(2, 2);
        red.move(2, 1);
        black.move(0, 0);

        System.out.println();

        black.move(1, 1);
        red.move(0, 0);
        black.move(0, 2);
        red.move(2, 0);
        black.move(1, 0);
        red.move(1, 2);
        black.move(2, 1);
        red.move(0, 1);
        black.move(2, 2);

        System.out.println();

        black.move(1,1);
        red.move(0,0);
        black.move(2,1);
        red.move(1,0);
        black.move(0,2);
        red.move(2,0);

        System.out.println();

        black.move(0,1);
        red.move(1,1);
        black.move(0,0);

        /// Exceptions
//        red.move(0,1);
//        red.move(0,3);
        red.move(0,2);
        black.move(1,0);
        red.move(2,0);
    }

    private static void checkBoard() {
        Board board = new Board();
        board.move(1, 1, 'O');
        board.move(1, 0, 'X');
        board.move(0, 0, 'O');
        board.move(2, 2, 'X');
        board.printBoard();
        board.move(0, 1, 'O');
        System.out.println(board.checkResult());
        board.move(0, 2, 'X');
        System.out.println(board.checkResult());
        board.printBoard();
        board.move(2, 1, 'O');
        System.out.println(board.checkResult());
        board.printBoard();

        board = new Board();
        board.move(1, 1, 'X');

        /// Exception
//        board.move(1, 2, 'O');
//        board.move(1, 3, 'O');

        board.move(0, 0, 'O');
        board.move(0, 2, 'X');
        board.move(2, 0, 'O');
        board.move(1, 0, 'X');
        board.move(1, 2, 'O');
        board.move(2, 1, 'X');
        board.move(0, 1, 'O');
        board.printBoard();
        System.out.println(board.checkResult());
        board.move(2, 2, 'X');
        board.printBoard();
        System.out.println(board.checkResult());
    }
}
