import java.io.File;

/**
 * class representing the items having a path,name and id
 */
public abstract class Item {
    protected String name;
    protected String id;
    protected String path;

    public Item(String name, String id, String path) throws MyException {
        File file = new File(path);
        if (!file.exists()) {
            throw new MyException(name + " file does not exist at " + path);
        }
        if (file.isDirectory()) {
            throw new MyException(name + " is a directory.");
        }
        this.name = name;
        this.path = path;
        this.id = id;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) throws MyException {
        File file = new File(path);
        if (!file.exists()) {
            throw new MyException(name + " file does not exist at " + path);
        }
        if (file.isDirectory()) {
            throw new MyException(name + " is a directory.");
        }
        this.path = path;
    }


}
