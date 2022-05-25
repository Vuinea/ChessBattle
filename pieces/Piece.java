package pieces;

import board.GameBoard;

import java.util.List;

public abstract class Piece {
    private int x;
    private int y;
    final TeamColor color;
    private boolean draggable;

    public Piece(TeamColor c, boolean draggable) {
        this.color = c;
        this.draggable = draggable;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public List<Integer> getPos() {
        int x = this.getX();
        int y = this.getY();
        return new ArrayList<>(Arrays.asList(x, y));
    }

//    making this because usually you would want to update them both at the same time
    public void setPos(int x, int y) {
        setX(x);
        setY(y);
    }

    public TeamColor getColor() {
        return this.color;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public void move(int x, int y, GameBoard board) {
        board.setTile(x, y, this);
    }

    public abstract List<List<Integer>> getPossibleMoves(GameBoard board);

}


