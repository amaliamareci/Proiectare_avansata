package panels;

import frame.MainFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * panels.ConfigPanel is used to get the user input for the numbers of the grid
 * of rows and columns and the resets the game grid
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner spinnerRows;
    JSpinner spinnerCols;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 20, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 20, 1));
        JButton createButton = new JButton("Create");

        add(new JLabel("Grid size:"));
        add(spinnerRows);
        add(spinnerCols);
        add(createButton);

        // adds a mouse listener for the create button and resizes the grid
        createButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frame.resetFrame();
            }
        });
    }

    public int getRows() {
        return Integer.parseInt(spinnerRows.getValue().toString());
    }

    public int getCols() {
        return Integer.parseInt(spinnerCols.getValue().toString());
    }

}