package pieces;

import board.GameBoard;

import java.util.List;

public class Rook extends Piece {
    public Rook(TeamColor c, boolean draggable) {
        super(c, draggable);
    }

    @Override
    public List<List<Integer>> getPossibleMoves(GameBoard board) {
        return null;
    }
}
