package command;

import base.Catalog;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;

public class ViewCommand extends Command {

    public ViewCommand(Catalog catalog) {
        super(catalog);
    }

    /**
     * opens the items via items.txt
     */
    public void run() {
        printCommandName();
        try {
            File path = new File("target\\items.txt");
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            if (desktop != null) {
                FileWriter fr = new FileWriter(path);
                fr.write(catalog.toString());
                fr.close();
                desktop.open(path);
            }
        } catch (Exception evt) {
            JOptionPane.showMessageDialog(new JFrame(), evt.getMessage());
        }
    }
    @Override
    public void printCommandName() {
        System.out.println("ViewCommand");
    }

}
