import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Canvas -in this class i am drawing the grid
 */
public class Canvas extends Panel {
    public Canvas() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);
    }

    /**
     * @param n -rows
     * @param m -columns
     * drawing the grid layout with n row and m columns
     */
    public void draw(int n, int m) {
        this.removeAll();
        this.repaint();

        final Border TOP_LEFT = new MatteBorder(1, 1, 1, 0, Color.DARK_GRAY);
        final Border TOP_RIGHT = new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
        final Border BOTTOM_LEFT = new MatteBorder(0, 1, 1, 0, Color.DARK_GRAY);
        final Border BOTTOM_RIGHT = new MatteBorder(0, 1, 1, 1, Color.DARK_GRAY);
        setLayout(new GridLayout(n, m));
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                Border border = null;
                int index = (row * n) + col;
                if (row == 0) {
                    if (col == m - 1) {
                        border = TOP_RIGHT;
                    } else {
                        border = TOP_LEFT;
                    }
                } else if (row == n - 1) {
                    if (col == m - 1) {
                        border = BOTTOM_RIGHT;
                    } else {
                        border = BOTTOM_LEFT;
                    }
                } else if (col == m - 1) {
                    border = BOTTOM_RIGHT;
                } else {
                    border = BOTTOM_LEFT;
                }
                JLabel cell = new JLabel(" ");
                cell.setBorder(border);
                add(cell);
            }
        }
        this.revalidate();
    }

}