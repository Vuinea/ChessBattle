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

        board.setTile(1, 1, myPawn);
        board.setTile(0, 2, secondPawn);
        board.setTile(2, 2, thirdPawn);
        List<List<Integer>> moves = myPawn.getPossibleMoves(board);
    }


//    move this to GameBoard later
//    public static boolean isPassant(List<Integer> row) {
////        TODO: Add attribute to pawn class that tracks whether the first move was 2 spaces or 1
//                int currentTile;
//                int nextTile;
//                for (int i = 0; i < row.size()-1; i++) {
//                    currentTile = row.get(i);
//                    nextTile = row.get(i+1);
////                    here add if one of tiles has moved 2 spaces then an En Passant is possible
//                    if (currentTile == -1 && nextTile == 1 || currentTile == 1 && nextTile == -1) return true;
//        }
//        return false;
//    }
}
