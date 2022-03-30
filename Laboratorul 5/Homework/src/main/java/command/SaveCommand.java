package command;

import base.Catalog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class SaveCommand extends Command {
    public SaveCommand(Catalog catalog) {
        super(catalog);
    }

    /**
     * @param fileName - the file where the catalog is going to be saved
     *saves the catalog in a json file
     */
    public void run(String fileName) {
        printCommandName();
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(fileName), this.catalog);
            String catalogJson = mapper.writeValueAsString(this.catalog);
        } catch (JsonProcessingException e) {
            System.out.println("processing exception in save method");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O exception in save method");
            e.printStackTrace();
        }
    }
    @Override
    public void printCommandName() {
        System.out.println("SaveCommand");
    }
}
