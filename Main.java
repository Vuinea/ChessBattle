import board.GameBoard;
import pieces.Pawn;
import pieces.TeamColor;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Pawn myPawn = new Pawn(TeamColor.BLACK, true);
        Pawn secondPawn = new Pawn(TeamColor.WHITE, true);
        Pawn thirdPawn = new Pawn(TeamColor.WHITE, true);
        Pawn fourthPawn = new Pawn(TeamColor.BLACK, true);

//        black pawns
        board.setTile(0, 1, myPawn);
        board.setTile(1, 1, fourthPawn);

//        white pawns
        board.setTile(0, 6, secondPawn);
        board.setTile(1, 6, thirdPawn);

        myPawn.move(myPawn.getX(), myPawn.getY() + 2, board, true);
        myPawn.move(myPawn.getX(), myPawn.getY() + 1, board);
        thirdPawn.move(thirdPawn.getX(), thirdPawn.getY() - 2, board, true);
        List<List<Integer>> moves = myPawn.getPossibleMoves(board);
        System.out.println(moves);

        board.printBoard();

    }


//    move this to GameBoard later
    /* public static boolean isPassant(List<Integer> row) {
                int currentTile;
                int nextTile;
                for (int i = 0; i < row.size()-1; i++) {
                    currentTile = row.get(i);
                    nextTile = row.get(i+1);
//                    here add if one of tiles has moved 2 spaces then an En Passant is possible
                    if (currentTile == -1 && nextTile == 1 || currentTile == 1 && nextTile == -1) return true;
        }
        return false;
    }

     */
}
