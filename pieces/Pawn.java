package pieces;

import board.GameBoard;
import board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean twoSpacesMoved;

    public Pawn(TeamColor c, boolean d) {
        super(c, d);
    }

    public void setTwoSpacesMoved(boolean twoSpacesMoved) {
        this.twoSpacesMoved = twoSpacesMoved;
    }

//    helper function to check if the target can be attacked
    private boolean tileCanBeAttacked(Tile target) {
        return !target.isEmpty() && target.getPiece().getColor() != this.getColor();
    }

//    this checks if the pawn can attack
    public boolean canAttack(GameBoard board) {
        int x = this.getX();
        int y = this.getY();
//        if tile is occupied
        int minusX = x - 1;
        int addX = x + 1;
        int addY = y + 1;
        Tile leftTile = board.getTile(minusX, addY);
        Tile rightTile = board.getTile(addX, addY);
        return this.tileCanBeAttacked(leftTile) || this.tileCanBeAttacked(rightTile);
    }

//    pawn simple just move 1 forward and diagonal for attack
    public List<List<Integer>> getPossibleMoves(GameBoard board) {
        int x = this.getX();
        int y = this.getY();
        List<List<Integer>> moves = new ArrayList<>();
        Tile forwardTile = board.getTile(x, y+1);
//        checking if the pawn can move forward 1 space
        if (forwardTile.isEmpty()) {
            moves.add(new ArrayList<>(List.of(x, y+1)));
        }

//        checking if pawn can move diagonal
        boolean canAttack = this.canAttack(board);
        if (canAttack) {
            Tile leftTile = board.getTile(x - 1, y + 1);
            Tile rightTile = board.getTile(x + 1, y + 1);
            if (tileCanBeAttacked(leftTile)) {
                moves.add(List.of(leftTile.getPiece().getX(), leftTile.getPiece().getY()));
            }

            if (tileCanBeAttacked(rightTile)) {
                moves.add(List.of(rightTile.getPiece().getX(), rightTile.getPiece().getY()));
            }
        }

        return moves;
    }

    public void attack(Piece target) {
        if (target.getColor() != this.getColor()) {
            this.setPos(target.getX(), target.getY());
        }
    }

}
