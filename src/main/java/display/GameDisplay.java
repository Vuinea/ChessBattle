package src.main.java.display;

import src.main.java.board.GameBoard;
import src.main.java.board.Tile;
import src.main.java.pieces.Piece;
import src.main.java.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GameDisplay extends JPanel implements MouseListener {
    private final GameBoard board;
    private static List<List<Integer>> highlightedTiles = new ArrayList<>();
    private Piece currentPiece = null;
    private Tile currentTile = null;

    public GameDisplay(GameBoard board) {
        super();
        this.board = board;
        this.addMouseListener(this);
    }

    public static void create(GameBoard b) {
        JFrame frame = new JFrame("Chess Battle");
        frame.setBounds(100, 100, 800, 800);
        GameDisplay panel = new GameDisplay(b);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        frame.add(panel);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (board == null) return;

        for (Tile tile : board.getAllTiles()) {
            this.add(tile);
            tile.paintComponent(graphics, highlightedTiles.contains(tile.getPos()));
        }
    }

    public static void setHighlightedTiles(List<List<Integer>> t) {
        highlightedTiles = t;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (this.hasTile(x, y)) {
            System.out.println("HAS TILE");
            Tile tile = this.getTile(x, y);

            if (this.hasCurrent()) {
                System.out.println("HAS CURRENT");
                setHighlightedTiles(currentPiece.getPossibleMoves(board));
                if (Utils.canMoveToTile(currentPiece, tile, board)) {
                    tile.setPiece(currentPiece);
                    currentTile.clear();
                    currentPiece = null;
                    currentTile = null;
                }
            } else {
                if (!tile.isEmpty()) {
                    currentPiece = tile.getPiece();
                    currentTile = tile;
                }
            }
        }

        repaint();
    }

    public boolean hasTile(int x, int y) {
        return this.getTile(x, y) != null;
    }

    public Tile getTile(int x, int y) {
        for (Component c : this.getComponents()) {
            if (c.getBounds().contains(x, y)) {
                return (Tile) c;
            }
        }
        return null;
    }

    public boolean hasCurrent() {
        return currentTile != null && currentPiece != null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
