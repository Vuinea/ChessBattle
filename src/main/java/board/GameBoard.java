package src.main.java.board;

import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.TeamColor;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    final Tile[][] board;

    public GameBoard() {
        Tile[] row;
        this.board = new Tile[8][8];
//        creating initial tiles
        for (int i = 0; i < this.getBoard().length; i++) {
            row = this.getBoard()[i];
            for (int j = 0; j < row.length; j++) {
                this.getBoard()[i][j] = new Tile(j, i, null);
            }
        }
        this.initPawns();
        this.initKnights();

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
        originalTile.clear();
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

//    for the pawns
    public List<Tile> getHorizontalTiles(int x, int y) {
        Tile currentTile = this.getTile(x, y);
        List<Tile> horizontalTiles = new ArrayList<>();
        if (this.isValidTile(x + 1, y)) {
            Tile leftTile = this.getTile(x + 1, y);
            horizontalTiles.add(leftTile);
        }
        if (this.isValidTile(x - 1, y)) {
            Tile rightTile = this.getTile(x - 1, y);
            horizontalTiles.add(rightTile);
        }
        return horizontalTiles;
    }

    public List<Tile> getRow(int y) {
        return new ArrayList<>(List.of(this.getBoard()[y]));
    }

    public List<Tile> getColumn(int columnNum) {
        Tile[][] board = this.getBoard();
        List<Tile> column = new ArrayList<>();

        Tile currentTile;
        for (Tile[] row : board) {
            currentTile = row[columnNum];
            column.add(currentTile);
        }

        return column;
    }

    private void initPawns() {
        //        adding the black pawns
        for (int i = 0; i < this.getBoard()[1].length; i++) {
            Pawn pawn = new Pawn(TeamColor.BLACK, true);
            pawn.putOnBoard(this);
        }

//        adding the white pawns
        for (int i = 0; i < this.getBoard()[6].length; i++) {
            Pawn pawn = new Pawn(TeamColor.WHITE, true);
            pawn.putOnBoard(this);
        }
    }

    private void initKnights() {
        Knight light1 = new Knight(TeamColor.WHITE, true);
        Knight light2 = new Knight(TeamColor.WHITE, true);
        this.setTile(1, 7, light1);
        this.setTile(6, 7, light2);

        Knight dark1 = new Knight(TeamColor.BLACK, true);
        Knight dark2 = new Knight(TeamColor.BLACK, true);
        this.setTile(1, 0, dark1);
        this.setTile(6, 0, dark2);


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
