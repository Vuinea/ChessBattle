package pieces;

import board.GameBoard;

public abstract class Piece {
    private int x;
    private int y;
    final TeamColor color;
    private boolean draggable;

    public Piece(TeamColor c, boolean d) {
        this.color = c;
        this.draggable = d;
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
}


