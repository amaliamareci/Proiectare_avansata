package command;

import base.*;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.*;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InfoCommand extends Command{
    public InfoCommand(Catalog catalog) {
        super(catalog);
    }

    /**
     * displays the metadata from catalog items
     */
    public void run()  {
        printCommandName();
        File file = new File("target/catalog.json");

        for(Item i: catalog.getItems()) {
            Metadata metadata = new Metadata();

            metadata.add(Metadata.TITLE, i.getTitle());
            metadata.add(Metadata.IDENTIFIER, i.getId());
            metadata.add(Metadata.LOCATION, i.getLocation());

            Parser parser = new EmptyParser();
            BodyContentHandler handler = new BodyContentHandler();
            try {
                FileInputStream inputstream = new FileInputStream(file);
                ParseContext context = new ParseContext();

                try {
                    parser.parse(inputstream, handler, metadata, context);
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TikaException e) {
                    e.printStackTrace();
                }
                System.out.println(handler.toString());

                String[] metadataNames = metadata.names();

                for (String name : metadataNames) {
                    System.out.println(name + ": " + metadata.get(name));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void printCommandName() {
        System.out.println("InfoCommand");
    }
}
