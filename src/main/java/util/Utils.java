package src.main.java.util;

import src.main.java.pieces.Knight;
import src.main.java.pieces.Piece;
import src.main.java.pieces.Rook;
import src.main.java.pieces.TeamColor;

public class Utils {
    public static final String WHITE = "\u001B[37m";
    public static final String BLACK = "\u001B[30m";
    public static final String RESET = "\u001B[0m";

    public static void printPiece(Piece piece) {
        String type = "Pawn";
        if (piece instanceof Knight) type = "Knight";
        else if (piece instanceof Rook) type = "Rook";

        String color = piece.getColor() == TeamColor.WHITE ? WHITE : BLACK;
        System.out.println(color + type + RESET);
    }

    public static boolean isWhite(Piece piece) {
        return piece.getColor() == TeamColor.WHITE;
    }

    public static int getColorForTile(int i, int j) {
        if (i % 2 == 0) {
            return j % 2;
        } else {
            if (j % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
