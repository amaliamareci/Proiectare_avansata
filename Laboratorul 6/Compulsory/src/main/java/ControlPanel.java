import java.awt.*;

/**
 * Control Panel (in South) -having two buttons(Load,Save)
 */
public class ControlPanel extends Panel {
    public ControlPanel() {
        setPreferredSize(new Dimension(100, 40));
        Color myGray = new Color(240, 240, 240);
        setBackground(myGray);
        Button b1 = new Button("Load");
        Button b2 = new Button("Save");
        add(b1);
        add(b2);
    }
}