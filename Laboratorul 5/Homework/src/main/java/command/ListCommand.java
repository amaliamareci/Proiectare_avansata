package command;

import base.Catalog;

public class ListCommand extends Command {

    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    /**
     * displays the catalog items
     */
    public void run() {
        printCommandName();System.out.println(catalog);
    }
    @Override
    public void printCommandName() {

        System.out.println("ListCommand");
    }
}
