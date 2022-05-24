package pieces;

import board.GameBoard;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(TeamColor c, boolean draggable) {
        super(c, draggable);
    }

    @Override
    public List<List<Integer>> getPossibleMoves(GameBoard board) {
        return null;
    }
}
