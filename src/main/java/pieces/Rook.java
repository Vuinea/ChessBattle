package src.main.java.pieces;

import src.main.java.board.GameBoard;
import src.main.java.board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(TeamColor c, boolean draggable) {
        super(c, draggable);
    }

    @Override
    public List<List<Integer>> getPossibleMoves(GameBoard board) {
        int x = this.getX();
        int y = this.getY();
        List<List<Integer>> moves = new ArrayList<>();
        List<Tile> tiles;
        List<Tile> row = board.getRow(y);
        List<Tile> column = board.getColumn(x);

//        setting initial values
        int startIndex = -1;
        int endIndex = -1;
        Piece currentPiece;

        for (Tile tile : row) {
            currentPiece = tile.getPiece();
            if (tile.getX() == 0) startIndex = 0;

            else if (currentPiece != null && currentPiece != this) {
                if (startIndex == -1) startIndex = currentPiece.getX();
                else {
                    endIndex = currentPiece.getX();
                    if (currentPiece.getColor() != this.getColor()) endIndex += 1;
                }
                ;
            }
            if (startIndex != -1 && endIndex != -1) break;
        }
//        this shows that it can across the whole row
        if (startIndex == -1) startIndex = 0;
        if (endIndex == -1) endIndex = 8;

        tiles = row.subList(startIndex, endIndex);
        for (Tile tile : tiles) {
            if (tile.getPos() != this.getPos())
                moves.add(tile.getPos());
        }
        
        return moves;
    }
}
