package src.main.java.pieces;

import src.main.java.board.GameBoard;
import src.main.java.board.Tile;
import src.main.java.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    //    these attributes are for En Passant
    private boolean canBePassant;

    public Pawn(TeamColor c, boolean draggable) {
        super(c, draggable);
    }

    public void putOnBoard(GameBoard board) {
        int currentY;
        if (this.getColor() == TeamColor.WHITE) {
            currentY = 6;
        } else {
            currentY = 1;
        }
//      I have to do the loop backward for some reason
        for (int x = 7; x >= 0; x--) {
            if (board.getTile(x, currentY).isEmpty()) {
                board.setTile(x, currentY, this);
            }
        }
    }

    public boolean canBePassant() {
        return canBePassant;
    }

    public void setCanBePassant(boolean canBePassant) {
        this.canBePassant = canBePassant;
    }

    public List<List<Integer>> getPassantPos(GameBoard board) {
        List<List<Integer>> positions = new ArrayList<>();
        List<Tile> adjacentTiles = board.getHorizontalTiles(this.getX(), this.getY());
        for (Tile tile : adjacentTiles) {
            if (tile.getPiece() instanceof Pawn target) {
                boolean isOnValidRow = (this.getColor() == TeamColor.BLACK && this.getY() == 4) || (this.getColor() == TeamColor.WHITE && this.getY() == 3);
                if (isOnValidRow && target.canBePassant() && target.getColor() != this.getColor())
                    positions.add(List.of(target.getX(), target.getY()));
            }
        }
        return positions;
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
        } else if (leftTileExists) {
            Tile leftTile = board.getTile(minusX, addY);
            return this.tileCanBeAttacked(leftTile);

        } else if (rightTileExists) {
            Tile rightTile = board.getTile(addX, addY);
            return this.tileCanBeAttacked(rightTile);
        } else return this.getPassantPos(board).size() != 0;
    }

    //    pawn move 1 forward and diagonal for attack and passant if possible
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

//        adding the En Passsant
        moves.addAll(this.getPassantPos(board));

        return moves;
    }

    public void move(int xSpaces, int ySpaces, GameBoard board, boolean firstMove) {
        int newX = this.getX() + xSpaces;
        int newY;
        if (this.getColor() == TeamColor.WHITE) {
            newY = this.getY() - ySpaces;

        } else {
            newY = this.getY() + ySpaces;
        }
        if (firstMove) {
//            checking if the player is moving 2 spaces
            this.setCanBePassant(ySpaces == 2);
        } else {
            this.setCanBePassant(false);
        }
        super.move(newX, newY, board);
    }

//    use method instead of move
    public void passant(Pawn target, GameBoard board) {
        Tile tile = board.getTile(target.getX(), target.getY());
        tile.clear();
        int newX = target.getX();
        int newY = target.getY() + this.getColor().getValue();
        super.move(newX, newY, board);
    }

    @Override
    public String getImageName() {
        return Utils.isWhite(this) ? "WhitePawn.png" : "BlackPawn.png";
    }
}
