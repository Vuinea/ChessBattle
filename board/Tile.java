package board;

import pieces.Piece;
import pieces.TeamColor;

public class Tile {
    private Piece piece;
    public Tile( Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void clear() {
        this.setPiece(null);
    }

    public boolean isEmpty() {
        return this.getPiece() == null;
    }

    public boolean canMoveTo(TeamColor pieceColor) {
        boolean empty = this.isEmpty();
        return empty || this.getPiece().getColor() != pieceColor;
    }

}
