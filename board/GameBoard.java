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

//    making this for visualisation delete later
    public void printBoard() {
        for (Tile[] row : this.getBoard()) {
            System.out.println("\n");
            for (Tile tile : row) {
                System.out.print(tile.getPiece() + " ");
            }
        }
    }
}
