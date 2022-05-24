import board.GameBoard;
import pieces.Knight;
import pieces.Pawn;
import pieces.TeamColor;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Knight knight = (Knight) board.getTile(1 ,0).getPiece();
        System.out.println(knight.getPossibleMoves(board));

        board.printBoard();
    }
}
