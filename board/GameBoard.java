package board;

import pieces.Piece;

public class GameBoard {
    final Tile[][] board;

    public GameBoard() {
        this.board = new Tile[8][8];
        for (Tile[] row : this.getBoard()) {
            for (int i = 0; i < row.length; i++) {
                row[i] = new Tile(null);
            }
        }
//        for (int i = 0; i < this.getBoard().length; i++) {
//            Tile[] row = this.getBoard()[i];
//            for (int j = 0; j < row.length; j++) {
//                Tile tile = new Tile(null);
//                row[j] = tile;
//            }
//        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public Tile getTile(int x, int y) {
        return this.getBoard()[x][y];
    }

    public void setTile(int x, int y, Piece piece) {
        Tile tile = this.getBoard()[x][y];
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
