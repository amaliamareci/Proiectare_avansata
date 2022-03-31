import javax.swing.*;
import java.awt.*;

/**
 * MainPanel for the game
 */
class MainPanel extends JPanel {
    public MainPanel() {
        setPreferredSize(new Dimension(500, 600));
        setLayout(new BorderLayout());
        Canvas canvas = new Canvas();
        add(canvas, "Center");
        ConfigurationPanel c = new ConfigurationPanel(canvas);
        add(c, "North");
        add(new ControlPanel(), "South");
        //System.out.println( c.row + ","+c.col);
        canvas.draw(10, 10);
    }
}