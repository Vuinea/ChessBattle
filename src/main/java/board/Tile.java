package src.main.java.board;

import src.main.java.pieces.Piece;
import src.main.java.pieces.TeamColor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tile extends JComponent {
    private Piece piece;
    final int x;
    final int y;
    private final int color;

    public Tile(int x, int y, Piece piece, int color) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        // Tile uses an integer for color due to ease of use
        this.color = color;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public List<Integer> getPos() {
        int x = this.getX();
        int y = this.getY();
        return new ArrayList<>(List.of(x, y));
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void clear() {
        this.setPiece(null);
    }

    public boolean isEmpty() {
        return this.getPiece() == null;
    }

    public boolean canMoveTo(TeamColor pieceColor) {
        boolean empty = this.isEmpty();
        return empty || this.getPiece().getColor() != pieceColor;
    }

    public int getColor() {
        if (color == 0 || color == 1) {
            return color;
        } else throw new IllegalArgumentException("Color must be black (1) or white (0)!");
    }

    // Paint this tile using its provided color and position
    public void paintComponent(Graphics graphics, boolean highlighted) {
        Color color = new Color(232, 237, 249);
        if (this.getColor() == 1) {
            color = new Color(183, 192, 216);
        }
        if (highlighted) {
            color = new Color(131, 77, 107);
        }

        int x = (this.getX() + 3) * 50;
        int y = (this.getY() + 3) * 50;

        graphics.setColor(color);
        graphics.fillRect(x, y, 50, 50);

        if (!this.isEmpty()) {
            Image image = this.getPiece().getImage();
            graphics.drawImage(image, x, y, 50, 50, null);
        }
    }
}