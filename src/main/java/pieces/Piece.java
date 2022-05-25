package src.main.java.pieces;

import src.main.java.board.GameBoard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Piece {
    private int x;
    private int y;
    final TeamColor color;
    private boolean draggable;
    private BufferedImage image = null;

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

    public BufferedImage getImage() {
        try {
            if (this.image == null) {
                this.image = ImageIO.read(getClass().getResource("/src/main/resources/" + this.getImageName()));
            }
        } catch (IOException e) {
            System.out.println("No Image Found (" + e.getMessage() + ")");
        }

        return this.image;
    }

    public abstract List<List<Integer>> getPossibleMoves(GameBoard board);

    public abstract String getImageName();
}


