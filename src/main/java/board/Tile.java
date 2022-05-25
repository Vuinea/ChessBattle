package src.main.java.board;

import src.main.java.pieces.Piece;
import src.main.java.pieces.TeamColor;

public class Tile {
    private Piece piece;
    final int x;
    final int y;

    public Tile(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public List<Integer> getPos() {
        int x = this.getX();
        int y = this.getY();
        return new ArrayList<>(List.of(x, y));
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
