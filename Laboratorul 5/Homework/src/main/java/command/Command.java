package command;

import base.Catalog;

abstract public class Command {
     Catalog catalog;

    public Command(Catalog catalog) {
        this.catalog = catalog;
    }
    public void printCommandName(){};
}