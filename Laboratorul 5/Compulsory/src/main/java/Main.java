import java.util.ArrayList;

/**
 * @author Mareci Ioana Amalia
 * main class of the problem
 */
public class Main {

    public static void main(String[] args) {

        try {
            Catalog catalog = new Catalog("Some books", "saved catalog/", new ArrayList<>());
            catalog.add(new Book("The Art of Computer Programming", "knuth67", "Books\\The Art of Computer Programming.txt", "Donald E. Knuth", "1967", "book"));
            catalog.add(new Book("The Java Language Specification", "java17", "Books\\The Java Language Specification.txt", "James Gosling & others", "2021", "book"));
            //catalog.list("\n", "\n");
            CatalogCommands.save(catalog, true);
            Catalog catalog2 = CatalogCommands.load("saved catalog/Some books.txtct");
            //System.out.println(catalog.toString());
            System.out.println(catalog2.toString());
        } catch (MyException e) {
            System.err.print(e.getMessage() + "\n");
        }

    }
}
