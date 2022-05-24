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
        int x = this.getX();
        int y = this.getY();
        int currentY;
        TeamColor color = this.getColor();
        int colorValue = color.getValue();

        Tile currentTile;

        for (int currentX = x - 2; currentX < x + 3; currentX++) {
            if (currentX == x) continue;
            if (currentX == x - 1 || currentX == x + 1) {
//                checking if y should be positive or negative
                currentY = y + 2;

                if (board.isValidTile(currentX, currentY)) {
                    currentTile = board.getTile(currentX, currentY);
                    if (currentTile.canMoveTo(color)) {
                        moves.add(List.of(currentX, currentY));
                    }
                }
                currentY = y - 2;
            } else {
                currentY = y + colorValue;
            }

            if (board.isValidTile(currentX, currentY)) {
                currentTile = board.getTile(currentX, currentY);
                if (currentTile.canMoveTo(color)) {
                    moves.add(List.of(currentX, currentY));
                }
            }

        }

        return moves;
    }

    public void move(int x, int y, GameBoard board) {
        super.move(x, y, board);
    }

}
