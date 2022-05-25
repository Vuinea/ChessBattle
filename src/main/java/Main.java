package src.main.java;

import src.main.java.board.GameBoard;
import src.main.java.util.Utils;


public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
    //    System.out.println(src.main.java.board.getColumn(1).get(0).getPiece());
        Utils.printPiece(board.getColumn(1).get(0).getPiece());
//        src.main.java.board.printBoard();
    }
}
