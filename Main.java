import board.GameBoard;
import pieces.Knight;
import pieces.Pawn;
import pieces.TeamColor;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        System.out.println(board.getColumn(1).get(0).getPiece());
//        board.printBoard();
    }
}
