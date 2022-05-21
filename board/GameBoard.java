package board;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    final Tile[][] board;

    public GameBoard() {
        this.board = new Tile[8][8];
        for (Tile[] row : this.getBoard()) {
            for (int i = 0; i < row.length; i++) {
                row[i] = new Tile(null);
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Tile getTile(int x, int y) {
        return this.getBoard()[y][x];
    }

    public void setTile(int x, int y, Piece piece) {
        Tile tile = this.getTile(x, y);
//        reseting the current tile that the piece is on
        Tile originalTile = this.getTile(piece.getX(), piece.getY());
        originalTile.setPiece(null);
        tile.setPiece(piece);
        piece.setPos(x, y);
    }

    public boolean isValidTile(int x, int y) {
        try {
            this.getTile(x, y);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public List<Tile> getHorizontalTiles(int x, int y) {
        Tile currentTile = this.getTile(x, y);
        List<Tile> horizontalTiles = new ArrayList<>();
        if (this.isValidTile(x+1, y)) {
            Tile leftTile = this.getTile(x+1, y);
            horizontalTiles.add(leftTile);
        }
        if (this.isValidTile(x-1, y)) {
            Tile rightTile = this.getTile(x-1, y);
            horizontalTiles.add(rightTile);
        }
        return horizontalTiles;
    }

    //    making this for visualisation delete later
    public void printBoard() {
        for (Tile[] row : this.getBoard()) {
            System.out.println("\n");
            System.out.print("[");
            for (Tile tile : row) {
                System.out.print(tile.getPiece() + ", ");
            }
            System.out.print("]");
        }
    }
}
