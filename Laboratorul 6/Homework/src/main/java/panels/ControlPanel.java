package panels;
import frame.MainFrame;
import panels.DrawingPanel;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Logger;

/**
 * Panel for the control buttons
 */
public class ControlPanel extends JPanel {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    final MainFrame frame;
    JButton exitBtn =new JButton("Exit");
    JButton loadBtn =new JButton("Load");
    JButton saveBtn =new JButton("Save");
    JButton photoBtn =new JButton("SS");
    public ControlPanel(MainFrame frame) {
        this.frame=frame;

        add(exitBtn);
        add(loadBtn);
        add(saveBtn);
        add(photoBtn);

        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        photoBtn.addActionListener(this::photoGame);
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
    private void loadGame(ActionEvent e){
        MainFrame f = null;
        try {
            FileInputStream fileIn = new FileInputStream("fileName.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            f = (MainFrame) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            LOGGER.warning("IOException");
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            LOGGER.warning("main.MainFrame class not found");
            c.printStackTrace();
            return;
        }
    }

    public void saveGame(ActionEvent e){
        try{

            FileOutputStream fileOutputStream = new FileOutputStream("fileName.txt");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(frame);

            objectOutputStream.close();

            LOGGER.info("Object Persisted");

        }catch(IOException ex){
            LOGGER.warning("IOException");

            ex.printStackTrace();

        }

    }
    public void photoGame(ActionEvent e){
        frame.canvas.getImage();
        frame.dispose();
    }

}
