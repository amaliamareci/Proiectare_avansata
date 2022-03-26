import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * class Catalog having a name ,a pth and a list of items(books)
 */
public class Catalog {
    private String name;
    private String path;
    private List<Item> items;

    //constructor
    public Catalog(String name, String path, List<Item> items) {
        this.name = name;
        this.path = path;
        this.items = items;
    }

    //get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCatalogItem(int index, Item item) {
        try {
            items.set(index, item);
        } catch (IndexOutOfBoundsException e) {
            System.err.print(e.getMessage() + "\n");
        }
    }

    public Item getCatalogItem(int index) {
        try {
            return items.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.print(e.getMessage() + "\n");
            return null;
        }
    }

    public Item getCatalogItem(String name) {
        return items.stream().filter((item) -> item.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Item> getItems() {
        return items;
    }

    /**
     * check if the item exists already and then add it to the list
     */
    public void add(Item catalogItem) throws MyException {
        try {
            AtomicBoolean exists = new AtomicBoolean(false);
            items.forEach((item) -> exists.set(exists.get() || item == catalogItem));
            if (exists.get()) {
                throw new MyException("The item already exists in this catalog");
            } else {
                items.add(catalogItem);
            }
        } catch (NullPointerException e) {
            System.err.print(e.getMessage() + "\n");
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", items=" + items +
                '}';
    }
}
