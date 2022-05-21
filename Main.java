import board.GameBoard;
import pieces.Pawn;
import pieces.TeamColor;



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

//        myPawn.move(0, 2, board, true);
//        myPawn.move(0, 1, board, false);
//        fourthPawn.move(0, 2, board, true);
//        myPawn.passant(fourthPawn, board);

//        always include firstMove because otherwise it will use the piece move(), which is not what you want
        fourthPawn.move(0, 2, board, true);
        fourthPawn.move(0, 1, board, false);
        myPawn.move(0, 2, board, true);
        fourthPawn.passant(myPawn, board);

        board.printBoard();

    }
}
