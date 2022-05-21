package board;

import pieces.Piece;

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
}
