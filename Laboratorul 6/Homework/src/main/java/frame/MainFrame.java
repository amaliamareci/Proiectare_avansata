package frame;
import panels.*;
import panels.ConfigPanel;
import panels.ControlPanel;
import panels.DrawingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * main.MainFrame of the application where I am creating the panels
 */
public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    ControlPanel controlPanel;
    public DrawingPanel canvas;
    public MainFrame(){
        super("My Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();

    }
    public void resetFrame() {
        remove(canvas);
        canvas = new DrawingPanel(this);
        this.add(canvas);
        pack();
        this.setVisible(true);
    }


}
