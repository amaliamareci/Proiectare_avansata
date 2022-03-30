package base;

import command.*;
import freemarker.template.*;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Homework -Lab 5
 * @author Mareci Ioana Amalia A2
 */
public class Main {

    public static void main(String[] args) throws IOException, TemplateException, TikaException, SAXException {
        Book b1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps",
                "1967", "Donald E. Knuth","book");
        Book b2 = new Book("java17", "The Java Language Specification",
                "https://docs.oracle.com/javase/specs/jls/se17/html/index.html",
                "2021", "James Gosling & others","book");
        Article a1=new Article("art11","Article nr.1","d:/articles/programming/art.ps","2021","Someone Popular");
        Article a2=new Article("art11","Article nr.1","d:/articles/programming/art.ps","2021","Someone Popular"); //to see the exception message

        Catalog catalog = new Catalog();

        catalog.add(b1);
        catalog.add(b2);
        catalog.add(a1);

        //for MyException
        //catalog.add(a2);

        //save command
        SaveCommand saveCommand = new SaveCommand(catalog);
        saveCommand.run("target/catalog.json");

        //load command
        Catalog catalog2 = new Catalog();
        LoadCommand loadCommand = new LoadCommand(catalog2);
        catalog2 = loadCommand.run("target/catalog.json");
        System.out.println(catalog2);

        //list command
        ListCommand listCommand = new ListCommand(catalog2);
        listCommand.run();

        //view command
        ViewCommand viewCommand = new ViewCommand(catalog);
        viewCommand.run();

        //report command
        ReportCommand reportCommand =new ReportCommand(catalog);
        reportCommand.run();

        //display metadata from catalog items
        InfoCommand infoCommand =new InfoCommand(catalog);
        infoCommand.run();

    }
}


