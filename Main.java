import board.GameBoard;
import pieces.Pawn;
import pieces.TeamColor;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Pawn myPawn = new Pawn(TeamColor.BLACK, true);
        Pawn secondPawn = new Pawn(TeamColor.BLACK, true);
        Pawn thirdPawn = new Pawn(TeamColor.WHITE, true);
        Pawn fourthPawn = new Pawn(TeamColor.WHITE, true);

        myPawn.putOnBoard(board);
        secondPawn.putOnBoard(board);
        thirdPawn.putOnBoard(board);
        fourthPawn.putOnBoard(board);

//        myPawn.move(myPawn.getX(), myPawn.getY() + 2, board, true);
//        myPawn.move(myPawn.getX(), myPawn.getY() + 1, board);
//        fourthPawn.move(fourthPawn.getX(), fourthPawn.getY() - 2, board, true);
//        myPawn.passant(thirdPawn, board);
        fourthPawn.move(fourthPawn.getX(), fourthPawn.getY() - 2, board, true);
        fourthPawn.move(fourthPawn.getX(), fourthPawn.getY() - 1, board);
        myPawn.move(myPawn.getX(), myPawn.getY() + 2, board, true);

        fourthPawn.passant(myPawn, board);
        board.printBoard();

    }
}
