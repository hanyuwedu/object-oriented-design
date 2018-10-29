package type.game.tictactoe.v2;

import type.game.tictactoe.v2.game.Board;
import type.game.tictactoe.v2.game.Game;
import type.game.tictactoe.v2.game.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Guest {
    public static void main(String[] args) {
//        boardTest();
//        gameTest();
        tictactoeTest();
    }

    private static void tictactoeTest() {
        Player red = new Player("red");
        Player black = new Player("black");
        List<Player> players = new ArrayList<>();
        players.add(red);
        players.add(black);

        TicTacToe ticTacToe = new TicTacToe(players);

        ticTacToe.move(1, 1, black);
        ticTacToe.move(0, 2, red);
        ticTacToe.move(2, 2, black);
        ticTacToe.move(2, 1, red);
        ticTacToe.move(0, 0, black);

        System.out.println();

        ticTacToe.move(1, 1, red);
        ticTacToe.move(0, 0, black);
        ticTacToe.move(0, 2, red);
        ticTacToe.move(2, 0, black);
        ticTacToe.move(1, 0, red);
        ticTacToe.move(1, 2, black);
        ticTacToe.move(2, 1, red);
        ticTacToe.move(0, 1, black);
        ticTacToe.move(2, 2, red);

        System.out.println();

        ticTacToe.move(1,1, black);
        ticTacToe.move(0,0, red);
        ticTacToe.move(2,1, black);
        ticTacToe.move(1,0, red);
        ticTacToe.move(0,2, black);
        ticTacToe.move(2,0, red);

        System.out.println();

        ticTacToe.move(1, 1, red);
        ticTacToe.move(0, 2, black);
        ticTacToe.move(2, 2, red);
        ticTacToe.move(2, 1, black);
        ticTacToe.move(0, 0, red);
    }

    private static void gameTest() {
        Random random = new Random(2);

        Player red = new Player("red");
        Player black = new Player("black");
        List<Player> players = new ArrayList<>();
        players.add(red);
        players.add(black);

        Game game = new Game(players, random);

        game.move(1, 1, black);
        game.move(0, 2, red);
        game.move(2, 2, black);
        game.move(2, 1, red);
        Result result = game.move(0, 0, black);
        System.out.println(result);

        System.out.println();

        game = new Game(players, random);
        game.move(1, 1, black);
        game.move(0, 0, red);
        game.move(0, 2, black);
        game.move(2, 0, red);
        game.move(1, 0, black);
        game.move(1, 2, red);
        game.move(2, 1, black);
        game.move(0, 1, red);
        result = game.move(2, 2, black);
        System.out.println(result);

        System.out.println();

        game = new Game(players, new Random(-1));
        game.move(0, 1, red);
        game.move(1, 1, black);
        game.move(0, 0, red);

        // Exceptions
//        game.move(0, 2, red);
//        game.move(0, 1, black);
//        game.move(0, 3, black);

        game.move(0, 2, black);
        game.move(1, 0, red);
        game.move(2, 0, black);
    }

    public static void boardTest() {
        Board board_4 = new Board(4);
        board_4.print();

        System.out.println();

        Board board_3 = new Board(3);
        board_3.print();

        System.out.println();

        board_3.move(0, 0, 'O');
        board_3.move(1, 0, 'O');
        System.out.println(board_3.checkResult());
        board_3.move(2, 0, 'O');
        System.out.println(board_3.checkResult());
        System.out.println();

        board_3 = new Board(3);
        board_3.move(1, 2, 'X');
        board_3.move(1, 1, 'X');
        System.out.println(board_3.checkResult());
        board_3.move(1, 0, 'X');
        System.out.println(board_3.checkResult());
        System.out.println();

        board_3 = new Board(3);
        board_3.move(2, 2, 'O');
        board_3.move(1, 1, 'O');
        System.out.println(board_3.checkResult());
        board_3.move(0, 0, 'O');
        System.out.println(board_3.checkResult());
        System.out.println();

        board_3 = new Board(3);
        board_3.move(1, 1, 'X');
        board_3.move(2, 0, 'X');
        System.out.println(board_3.checkResult());
        board_3.move(0, 2, 'X');
        System.out.println(board_3.checkResult());
        System.out.println();

        board_3 = new Board(3);
        board_3.move(0, 0, 'X');
        board_3.move(0, 1, 'O');
        board_3.move(0, 2, 'O');
        board_3.move(1, 0, 'O');
        board_3.move(1, 1, 'X');
        System.out.println(board_3.checkResult());
        board_3.print();
        board_3.move(1, 2, 'X');
        board_3.move(2, 0, 'X');
        board_3.move(2, 1, 'X');
        board_3.move(2, 2, 'O');
        System.out.println(board_3.checkResult());
        board_3.print();
    }
}
