package src.main.java.display;

import src.main.java.board.GameBoard;
import src.main.java.board.Tile;

import javax.swing.*;
import java.awt.*;

public class GameDisplay extends JPanel {
    private static GameBoard board = null;

    public static void setBoard(GameBoard b) {
        board = b;
    }

    public static void create() {
        JFrame frame = new JFrame("Chess Battle");
        frame.setBounds(100, 100, 800, 800);
        frame.add(new GameDisplay());
        frame.setResizable(false);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics graphics) {
        if (board == null) return;

        for (Tile[] row : board.getBoard()) {
            for (Tile tile : row) {
                tile.paintComponent(graphics);
            }
        }
    }
}
