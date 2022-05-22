import board.GameBoard;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.TeamColor;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        // Black Knights
        Knight knight1 = new Knight(TeamColor.BLACK, true);
        Knight knight2 = new Knight(TeamColor.BLACK, true);
        board.setTile(1, 0, knight1);
        board.setTile(6, 0, knight2);

        // White Knights
        Knight knight3 = new Knight(TeamColor.WHITE, true);
        Knight knight4 = new Knight(TeamColor.WHITE, true);
        board.setTile(1, 7, knight3);
        board.setTile(6, 7, knight4);

        System.out.println(knight1.getPossibleMoves(board));

//        board.printBoard();
    }
}
