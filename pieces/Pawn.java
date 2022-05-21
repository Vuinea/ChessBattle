package pieces;

import board.GameBoard;
import board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
//    these attributes are for En Passant
    private boolean twoSpacesMoved;
    private int originalX;
    private int originalY;

    public Pawn(TeamColor c, boolean d) {
        super(c, d);
    }

    public boolean isTwoSpacesMoved() {
        return twoSpacesMoved;
    }

    public void setTwoSpacesMoved(boolean twoSpacesMoved) {
        this.twoSpacesMoved = twoSpacesMoved;
    }

    private int getOriginalX() {
        return this.originalX;
    }

    private void setOriginalX(int x) {
        this.originalX = x;
    }

    private int getOriginalY() {
        return this.originalY;
    }

    private void setOriginalY(int y) {
        this.originalY = y;
    }

    //    helper function to check if the target can be attacked
    private boolean tileCanBeAttacked(Tile target) {
        return !target.isEmpty() && target.getPiece().getColor() != this.getColor();
    }

    //    this checks if the pawn can attack
    public boolean canAttack(GameBoard board) {
        int x = this.getX();
        int y = this.getY();
        int minusX = x - 1;
        int addX = x + 1;
        int addY = y + 1;
//        isValidTile just makes sure that the indexes are in range
        boolean leftTileExists = board.isValidTile(minusX, addY);
        boolean rightTileExists = board.isValidTile(addX, addY);
//        0 is the left most column and 8 is the top row
        if (leftTileExists && rightTileExists) {
            Tile leftTile = board.getTile(minusX, addY);
            Tile rightTile = board.getTile(addX, addY);
            return this.tileCanBeAttacked(leftTile) || this.tileCanBeAttacked(rightTile);
        }
        else if (leftTileExists) {
            Tile leftTile = board.getTile(minusX, addY);
            return this.tileCanBeAttacked(leftTile);

        } else if (rightTileExists) {
            Tile rightTile = board.getTile(addX, addY);
            return this.tileCanBeAttacked(rightTile);

        }
        return false;
    }

    //    pawn simple just move 1 forward and diagonal for attack
    public List<List<Integer>> getPossibleMoves(GameBoard board) {
        int x = this.getX();
        int y = this.getY();
        List<List<Integer>> moves = new ArrayList<>();
        Tile forwardTile = board.getTile(x, y + 1);
//        checking if the pawn can move forward 1 space
        if (forwardTile.isEmpty()) {
            moves.add(new ArrayList<>(List.of(x, y + 1)));
        }

//        checking if pawn can move diagonal
        boolean canAttack = this.canAttack(board);
        if (canAttack) {
            int minusX = x - 1;
            int addX = x + 1;
            int addY = y + 1;
            boolean leftTileExists = board.isValidTile(minusX, addY);
            boolean rightTileExists = board.isValidTile(addX, addY);
            if (leftTileExists) {
                Tile leftTile = board.getTile(minusX, addY);
                if (tileCanBeAttacked(leftTile)) {
                    moves.add(List.of(leftTile.getPiece().getX(), leftTile.getPiece().getY()));
                }
            }
            if (rightTileExists) {
                Tile rightTile = board.getTile(addX, addY);
                if (tileCanBeAttacked(rightTile)) {
                    moves.add(List.of(rightTile.getPiece().getX(), rightTile.getPiece().getY()));
                }
            }
        }

        return moves;
    }

    public void move(int x, int y, GameBoard board, boolean firstMove) {
        if (firstMove) {
            this.setOriginalX(this.getX());
            this.setOriginalY(this.getY());
            this.setTwoSpacesMoved(y - 2 == this.getY());
        }
        super.move(x, y, board);
    }
}
