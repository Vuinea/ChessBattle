package pieces;

import board.GameBoard;
import board.Tile;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(TeamColor color, boolean draggable) {
        super(color, draggable);
    }

    public List<List<Integer>> getPossibleMoves(GameBoard board) {
        List<List<Integer>> moves = new ArrayList<>();
        int currentX = this.getX() + 1;
        int currentY;

        if (this.getColor() == TeamColor.WHITE) {
            currentY = this.getY() - 2;
        } else {
            currentY = this.getY() + 2;
        }

        Tile currentTile;

        if (board.isValidTile(currentX, currentY)) {
            currentTile = board.getTile(currentX, currentY);
            if (currentTile.isEmpty() || (!currentTile.isEmpty() && currentTile.getPiece().getColor() != this.getColor())) {
                moves.add(List.of(currentX, currentY));
            }
        }

            currentX = this.getX() - 1;

        if (board.isValidTile(currentX, currentY)) {
            currentTile = board.getTile(currentX, currentY);
            if (currentTile.isEmpty() || (!currentTile.isEmpty() && currentTile.getPiece().getColor() != this.getColor())) {
                moves.add(List.of(currentX, currentY));
            }
        }

        currentX = this.getX() + 2;
        currentY = this.getY() + 1;

        if (board.isValidTile(currentX, currentY)) {
            currentTile = board.getTile(currentX, currentY);
            if (currentTile.isEmpty() || (!currentTile.isEmpty() && currentTile.getPiece().getColor() != this.getColor())) {
                moves.add(List.of(currentX, currentY));
            }
        }

        currentY = this.getY() - 1;

        if (board.isValidTile(currentX, currentY)) {
            currentTile = board.getTile(currentX, currentY);
            if (currentTile.isEmpty() || (!currentTile.isEmpty() && currentTile.getPiece().getColor() != this.getColor())) {
                moves.add(List.of(currentX, currentY));
            }
        }

        currentX = this.getX() - 2;

        if (board.isValidTile(currentX, currentY)) {
            currentTile = board.getTile(currentX, currentY);
            if (currentTile.isEmpty() || (!currentTile.isEmpty() && currentTile.getPiece().getColor() != this.getColor())) {
                moves.add(List.of(currentX, currentY));
            }
        }

        currentY = this.getY() + 1;

        if (board.isValidTile(currentX, currentY)) {
            currentTile = board.getTile(currentX, currentY);
            if (currentTile.isEmpty() || (!currentTile.isEmpty() && currentTile.getPiece().getColor() != this.getColor())) {
                moves.add(List.of(currentX, currentY));
            }
        }


        return moves;
    }

    public void move(int x, int y, GameBoard board) {
        super.move(x, y, board);
    }

}
