import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * ConfigurationPanel having two spinners for rows and columns
 */
public class ConfigurationPanel extends Panel {
    protected int row = 9;
    protected int col = 9;

    public ConfigurationPanel(Canvas canvas) {
        setPreferredSize(new Dimension(100, 40));
        Color myGray = new Color(240, 240, 240);
        setBackground(myGray);
        JLabel label1 = new JLabel("Test");
        label1.setText("Grid Size:");
        add(label1);
        SpinnerModel model = new SpinnerNumberModel(10, 1, 15, 1);
        //for rows
        JSpinner spinner1 = new JSpinner(model);
        //for columns
        SpinnerModel model2 = new SpinnerNumberModel(10, 1, 15, 1);
        JSpinner spinner2 = new JSpinner(model2);


        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner spinner = (JSpinner) e.getSource();
                int value = (int) spinner.getValue();
                row = value;
                canvas.draw(row, col);
                System.out.println("Value is " + value);
            }
        });

        spinner2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                JSpinner spinner = (JSpinner) e.getSource();
                int value = (int) spinner.getValue();
                col = value;
                canvas.draw(row, col);
                System.out.println("Value is " + value);
            }
        });
        add(spinner1);
        add(spinner2);


        Button b1 = new Button("Create");
        add(b1);
    }

}
